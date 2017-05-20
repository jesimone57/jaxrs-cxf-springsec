package com.aver.restful;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.stereotype.Component;

@Component
@Path("/prime")
public class PrimeNumberServiceImpl implements PrimeNumberService {


	@GET
	@Produces("text/plain")
	@Path("/isprime/{number}/")
	public Boolean isPrimeNumber(@PathParam("number") Integer number) {
		PrimeNumbers primes = new PrimeNumbers();
		primes.setStart(number);
		primes.setEnd(number);
		primes.setPrimeNumbers(computePrimes(number, number));
		return (! primes.getPrimeNumbers().isEmpty());
	}

	@GET
	@Produces("text/plain")
	@Path("/primesinrange/{start}/{end}/")
	public PrimeNumbers getPrimesNumbersInRange(@PathParam("start") Integer start, @PathParam("end") Integer end) {
		PrimeNumbers primes = new PrimeNumbers();
		primes.setStart(start);
		primes.setEnd(end);
		primes.setPrimeNumbers(computePrimes(start, end));
		return primes;
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/factorsinrange/{start}/{end}/")
	public Map<Integer, List<Integer>> getFactorsInRange(@PathParam("start") int start, @PathParam("end") int end) {
		Map<Integer, List<Integer>> map = new TreeMap<Integer, List<Integer>>();
		for (int i = start; i <= end; i++) {
			List<Integer> factors = computePrimeFactorization(i);
			map.put(i, factors);
		}
		return map;
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON) //"application/json"
	@Path("/factors/{number}")
	public List<Integer> getPrimeFactorization(@PathParam("number") int number) {
		return computePrimeFactorization(number);
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON) //"application/json"
	@Path("/gcd/{number1}/{number2}")
	/**
	 * The GCD is the product of all the common prime factors between the two given numbers.
	 * Also known as the Greatest Common Factor (GCF).
	 * http://stackoverflow.com/questions/4201860/how-to-find-gcf-lcm-on-a-set-of-numbers
	 */
	public int getGreatestCommonDivisor(@PathParam("number1") int number1, @PathParam("number2") int number2) {
		List<Integer> factors1 = computePrimeFactorization(number1);
		List<Integer> factors2 = computePrimeFactorization(number2);
		int product = 1;
		for (Integer factor: factors1) {
			if (factors2.contains(factor)) {
				product *= factor;
				factors2.remove(factor); // this common factor already accounted for.  Do not use again.
			}
		}
		return product;
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON) //"application/json"
	@Path("/lcm/{number1}/{number2}")
	/**
	 * The LCM is the product of all the common prime factors pairs and all the unique factors from the two given numbers.
	 * http://stackoverflow.com/questions/4201860/how-to-find-gcf-lcm-on-a-set-of-numbers
	 */
	public int getLeastCommonMultiple(@PathParam("number1") int number1, @PathParam("number2") int number2) {
		List<Integer> factors1 = computePrimeFactorization(number1);
		List<Integer> factors2 = computePrimeFactorization(number2);
		int product = 1;
		//List<Integer> common = new ArrayList<Integer>();
		//List<Integer> unique = new ArrayList<Integer>();
		for (Integer factor: factors1) {
			if (factors2.contains(factor)) {
				factors2.remove(factor); // this common factor already accounted for.  Do not use again.
				//common.add(factor);
				product *= factor;
			} else {
				//unique.add(factor);
				product *= factor;
			}
		}
		for (Integer factor: factors2) {
			product *= factor;
		}
		return product;
	}

	
	private List<Integer> computePrimes(int start, int end) {
		List<Integer> primes = new ArrayList<Integer>();
		
		// swap the range if reversed
		if (end < start) {
			int temp = start;
			start = end;
			end = temp;
		}
		
		if (start <= 1) {
			start = 2;
		}

		// if start is even, then make it odd
		if (start%2 == 0 && start != 2) { 
			start++;
		}
		
		if (end < start) {
			return primes;
		}
				
		if (start == 2) {
			primes.add(2);
			start++;
		}
		
		for (int i=start; i <= end; i=i+2) {			
			boolean hasFactor = false;
			for (int j=3 ; j <= Math.sqrt(Double.valueOf(i)) ; j=j+2) {
				if (i%j == 0) {
					hasFactor = true;
					break;
				} 
			}
			if (! hasFactor) primes.add(i);
		}
		
		return primes;
	}
	
	private List<Integer>  computePrimeFactorization(int number) {
		long maxPossibleFactor = Math.round(Math.sqrt(Double.valueOf(number))); 
		//System.out.println("max possible factor="+maxPossibleFactor);
 		List<Integer> primes = getPrimesNumbersInRange(2, (int)maxPossibleFactor).getPrimeNumbers();
		//System.out.println(primes);
		
		List<Integer> factors = new ArrayList<Integer>();
		for (Integer divisor : primes) {
			//System.out.println("\tdivisor="+divisor+"   number%divisor="+number%divisor);
			while (number%divisor == 0) {
				factors.add(divisor);
				number /= divisor;
				//System.out.println("number is now "+number);
			}
			if (number == 1) {
				break;
			}
		}
		if (factors.isEmpty() || number > 1) {
			factors.add(number);
		}
		return factors;
	}

}