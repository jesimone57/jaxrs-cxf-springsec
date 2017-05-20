package com.aver.restful;

import java.util.List;
import java.util.Map;

public interface PrimeNumberService {

	Boolean isPrimeNumber(Integer n);
	PrimeNumbers getPrimesNumbersInRange(Integer start, Integer end);

	List<Integer> getPrimeFactorization(int i);	
	Map<Integer, List<Integer>> getFactorsInRange(int start, int end);
	
	int getGreatestCommonDivisor(int number1, int number2);
	int getLeastCommonMultiple(int number1, int number2);
}
