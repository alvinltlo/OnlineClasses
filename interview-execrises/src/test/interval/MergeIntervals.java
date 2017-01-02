package test.interval;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class MergeIntervals {
	public static void main(String[] arg) {
		ArrayList<Interval> array = new ArrayList<Interval>();
		Interval a = new Interval(1, 3);
		Interval b = new Interval(2, 6);
		Interval c = new Interval(8, 10);
		Interval d = new Interval(15, 18);
		array.add(a);
		array.add(b);
		array.add(c);
		array.add(d);
		print(array);
		System.out.println("\n");
		ArrayList<Interval> result = merge(array);
		print(result);
	}

	public static ArrayList<Interval> merge(ArrayList<Interval> intervals) {

		if (intervals == null || intervals.size() <= 1)
			return intervals;

		// sort intervals by using self-defined Comparator
		Collections.sort(intervals, new IntervalComparator());

		ArrayList<Interval> result = new ArrayList<Interval>();

		Interval prev = intervals.get(0);
		for (int i = 1; i < intervals.size(); i++) {
			Interval curr = intervals.get(i);
			if (prev.end >= curr.start) {
				// merged case
				Interval merged = new Interval(prev.start, Math.max(prev.end,
				        curr.end));
				prev = merged;
			} else {
				result.add(prev);
				prev = curr;
			}
		}
		result.add(prev);
		return result;
	}

	public static void print(ArrayList<Interval> array) {
		for (Interval i : array) {
			System.out.print(i + " , ");
		}
	}
}

class IntervalComparator implements Comparator<Interval> {
	public int compare(Interval i1, Interval i2) {
		return i1.start - i2.start;
	}
}
