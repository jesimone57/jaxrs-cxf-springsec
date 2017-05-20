import java.util.Arrays;
import java.util.List;

import junit.framework.TestCase;

import org.junit.Test;

import com.aver.restful.PrimeNumberService;
import com.aver.restful.PrimeNumberServiceImpl;


public class PrimesUnitTest  extends TestCase {
	
	@Test
	public void test_generatePrimesTo100() throws Exception {
		
		Integer [] expected = {3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97};
		PrimeNumberService primeService = new PrimeNumberServiceImpl();
		List<Integer> list = primeService.getPrimesNumbersInRange(3, 100).getPrimeNumbers();
		assertEquals("prime number list is incorrect", Arrays.asList(expected), list);
	}
	
	public void test_generatePrimes2to10() throws Exception {
		Integer [] expected = {2, 3, 5, 7};
		PrimeNumberService primeService = new PrimeNumberServiceImpl();
		List<Integer> list = primeService.getPrimesNumbersInRange(2, 10).getPrimeNumbers();
		assertEquals("prime number list is incorrect", Arrays.asList(expected), list);
	}
	
	public void test_generatePrimes2() throws Exception {
		Integer [] expected = {2};
		PrimeNumberService primeService = new PrimeNumberServiceImpl();
		List<Integer> list = primeService.getPrimesNumbersInRange(2, 2).getPrimeNumbers();
		assertEquals("prime number list is incorrect", Arrays.asList(expected), list);
	}
	
	public void test_generatePrimes1() throws Exception {
		Integer [] expected = {2};
		PrimeNumberService primeService = new PrimeNumberServiceImpl();
		List<Integer> list = primeService.getPrimesNumbersInRange(1, 2).getPrimeNumbers();
		assertEquals("prime number list is incorrect", Arrays.asList(expected), list);
	}
	
	public void test_generatePrimesBackwardsRange() throws Exception {
		Integer [] expected = {3, 5};
		PrimeNumberService primeService = new PrimeNumberServiceImpl();
		List<Integer> list = primeService.getPrimesNumbersInRange(5, 3).getPrimeNumbers();
		assertEquals("prime number list is incorrect", Arrays.asList(expected), list);
	}
	
	public void test_generatePrimesLessThan2() throws Exception {
		Integer [] expected = {2, 3};
		PrimeNumberService primeService = new PrimeNumberServiceImpl();
		List<Integer> list = primeService.getPrimesNumbersInRange(-1, 3).getPrimeNumbers();
		assertEquals("prime number list is incorrect", Arrays.asList(expected), list);
	}
	
	public void test_generatePrimesLessThan1() throws Exception {
		Integer [] expected = {};
		PrimeNumberService primeService = new PrimeNumberServiceImpl();
		List<Integer> list = primeService.getPrimesNumbersInRange(-1, 1).getPrimeNumbers();
		assertEquals("prime number list is incorrect", Arrays.asList(expected), list);
	}
	
	public void test_isPrime101() throws Exception {
		PrimeNumberService primeService = new PrimeNumberServiceImpl();
		assertTrue("prime number incorrect", primeService.isPrimeNumber(101));
	}
	
	public void test_isNotPrime4() throws Exception {
		PrimeNumberService primeService = new PrimeNumberServiceImpl();
		assertFalse("prime number incorrect", primeService.isPrimeNumber(4));
	}
	
	public void test_generatePrimes4_4() throws Exception {
		Integer [] expected = {};
		PrimeNumberService primeService = new PrimeNumberServiceImpl();
		List<Integer> list = primeService.getPrimesNumbersInRange(4, 4).getPrimeNumbers();
		assertEquals("prime number list is incorrect", Arrays.asList(expected), list);
	}
	
	public void test_primeFactorization2() throws Exception {
		Integer [] expected = {2};
		PrimeNumberService primeService = new PrimeNumberServiceImpl();
		List<Integer> list = primeService.getPrimeFactorization(2);
		assertEquals("prime factors are incorrect", Arrays.asList(expected), list);
	}
	
	public void test_primeFactorization6() throws Exception {
		Integer [] expected = {2, 3};
		PrimeNumberService primeService = new PrimeNumberServiceImpl();
		List<Integer> list = primeService.getPrimeFactorization(6);
		assertEquals("prime factors are incorrect", Arrays.asList(expected), list);
	}
	
	public void test_primeFactorization96() throws Exception {
		Integer [] expected = {2, 2, 2, 2, 2, 3};
		PrimeNumberService primeService = new PrimeNumberServiceImpl();
		List<Integer> list = primeService.getPrimeFactorization(96);
		assertEquals("prime factors are incorrect", Arrays.asList(expected), list);
	}
	
	public void test_primeFactorization101() throws Exception {
		Integer [] expected = {101};
		PrimeNumberService primeService = new PrimeNumberServiceImpl();
		List<Integer> list = primeService.getPrimeFactorization(101);
		assertEquals("prime factors are incorrect", Arrays.asList(expected), list);
	}
	
	public void test_primeFactorization5735() throws Exception {
		Integer [] expected = {5, 31, 37};
		PrimeNumberService primeService = new PrimeNumberServiceImpl();
		List<Integer> list = primeService.getPrimeFactorization(5735);
		assertEquals("prime factors are incorrect", Arrays.asList(expected), list);
	}
	
	public void test_primeFactorization() throws Exception {
		PrimeNumberService primeService = new PrimeNumberServiceImpl();
		for (int i=2; i<= 10001; i++) {
			List<Integer> factors = primeService.getPrimeFactorization(i);
			//System.out.println(i+"   "+factors);
			int product = 1;
			for (Integer factor: factors) {
				product *= factor;
			}
			assertEquals("prime factors are incorrect", i, product);
		}
	}
	
	public void test_isPrime() throws Exception {
		PrimeNumberService primeService = new PrimeNumberServiceImpl();
		for (int i=2; i<= 10001; i++) {
			List<Integer> factors = primeService.getPrimeFactorization(i);
			//System.out.println(i+"   "+factors);
			if (factors.size() == 1) {
				assertTrue(i+" should be prime and is not", primeService.isPrimeNumber(i));
			} else {
				assertFalse(i+" should not be prime and is", primeService.isPrimeNumber(i));
			}
		}
	}
	
	public void test_leastCommonMultiple() throws Exception {

		PrimeNumberService primeService = new PrimeNumberServiceImpl();
		int lcm = primeService.getLeastCommonMultiple(28, 48);
		assertEquals("lcm is incorrect", 336, lcm);
		
		lcm = primeService.getLeastCommonMultiple(250, 75);
		assertEquals("lcm is incorrect", 750, lcm);
		
		lcm = primeService.getLeastCommonMultiple(88, 40);
		assertEquals("lcm is incorrect", 440, lcm);
	}

}
