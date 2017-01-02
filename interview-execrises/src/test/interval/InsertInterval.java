package test.interval;

import java.util.ArrayList;

/**
 * Given a set of non-overlapping & sorted intervals, insert a new interval into
 * the intervals (merge if necessary).
 */
public class InsertInterval {

	public static void main(String[] arg) {
		Interval a = new Interval(1, 3);
		Interval b = new Interval(6, 9);
		ArrayList<Interval> array = new ArrayList<Interval>();
		array.add(a);
		array.add(b);
		print(array);
		System.out.println("\n");
		ArrayList <Interval> result =insert(array, new Interval(2,5));
		print(result);

		System.out.println("\n");
		array.clear();
		Interval c = new Interval(1, 2);
		Interval d = new Interval(3, 5);
		Interval e = new Interval(6, 7);
		Interval f = new Interval(8, 10);
		Interval g = new Interval(12, 16);
		array.add(c);
		array.add(d);
		array.add(e);
		array.add(f);
		array.add(g);
		print(array);
		System.out.println("\n");
		result =insert(array, new Interval(4,9));
		print(result);
	}

	public static void print(ArrayList<Interval> array) {
		for (Interval i : array) {
			System.out.print(i + " , ");
		}
	}

	public static ArrayList<Interval> insert(ArrayList<Interval> array,
	        Interval newInterval) {
		ArrayList<Interval> result = new ArrayList<Interval>();
        for(Interval interval: array){
            if(interval.end < newInterval.start){
            	System.out.println("case 2");
                result.add(interval);
            }else if(interval.start > newInterval.end){
                result.add(newInterval);
                newInterval = interval;
                System.out.println("case 1: " + newInterval);
            }else if(interval.end >= newInterval.start || interval.start <= newInterval.end){
                newInterval = new Interval(Math.min(interval.start, newInterval.start), Math.max(newInterval.end, interval.end));
                System.out.println("case 3: " + newInterval);
            }
        }
		result.add(newInterval);
		return result;
	}
}
