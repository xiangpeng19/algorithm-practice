/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */


import java.util.ArrayList;
import java.util.List;


public class Solution {
    public List<Interval> merge(List<Interval> intervals) {
    	if (intervals.size() <= 1) return intervals;
    	int i = 0;
    	while (intervals.size() > i+1) {
    		if (intervals.get(i).end >= intervals.get(i+1).start) {
    			intervals.get(i).end = intervals.get(i+1).end;
    			intervals.remove(i+1);

    		}
    		else i++;
    	}
    	return intervals;
    }
    
    
    public static void main(String[] args) {
		Interval i1 = new Interval(1, 4);
		Interval i2 = new Interval(0, 4);
		List<Interval> intervals = new ArrayList<Interval>();
		intervals.add(i1);
		intervals.add(i2);
		List<Interval> i = new Solution().merge(intervals);
		for (Interval interval : i) {
			System.out.println(interval.start + interval.end);
		} 
	}
}
