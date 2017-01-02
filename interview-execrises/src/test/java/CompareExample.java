package test.java;

import java.util.Comparator;

public class CompareExample {

	// Comparable example
	class Person implements Comparable {
		public int compareTo(Object c) {
			// Return 0 if both objects are "equals"
			// Return negative if "this" less than object c
			// Return postive if "this" greater than object c
			return 0;
		}
	}
	
	class PersonUtil implements Comparator {
	  public int compare (Object c1, Object c2) {
		  return 0;
	  }
	}
}
