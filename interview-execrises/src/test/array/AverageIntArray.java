package test.array;

import java.util.ArrayList;

/**
 * From WalMart eCommerce onsite interview Given an integer array [] 
 * e.g. 3, 4, 5, 8, 9
 * 
 * Write a retrieve method that will return the average value given an specific
 * position. 
 * e.g. retrieve (3) 
 * Array index: 0 1 2 3 4 
 * Array value: 3 4 5 8 9 
 * The position is 3.
 * The result will be averaging the Array value 9+8+5/3 = 7.333
 * 
 * e.g. retrieve (2)
 * The result will be average the Array value 8+9/2 = 8.5
 * 
 * Fast solution, when you add the int, create a new array with previous sum
 * Array 	index: 	0 1  2  3  4
 * Array sum value: 3 7 12 20 29
 * 
 * To calculate retrieve (3), we get 29 - 7 = 22, and then divide by 3 = 7.33
 * To calculate retrieve (2), we get 29 - 12 = 17, and then divide by 2 = 8.5
 */

public class AverageIntArray {

	public static void main(String[] args) {
		Average avg = new Average();
		
		avg.add(3);
		avg.add(4);
		avg.add(5);
		avg.add(8);
		avg.add(9);
		avg.printArray();
		
		System.out.println("\nlookback 3: " + avg.retrieve(3));
		System.out.println("\nlookback 2: " + avg.retrieve(2));
	}
}

class Average {
	ArrayList<Integer> sums = new ArrayList<Integer>();

	public void add(int newValue) {
		if (sums.size() == 0)
			sums.add(newValue);
		else {
			int previousSum = sums.get(sums.size() - 1);
			sums.add(newValue + previousSum);
		}
	}

	public double retrieve(int lookback) {
		if (sums.size() < lookback)
			throw new IllegalArgumentException();
		else {
			int lastValue = sums.get(sums.size() - 1);
			int firstValue = sums.get(sums.size() - 1 - lookback);
			return (double)(lastValue - firstValue) / lookback;
		}
	}
	
	public void printArray() {
		for (int i: sums){
			System.out.print(i +",");
		}
	}
}