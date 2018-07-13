/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
class Solution {
    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        List<Interval> res = new ArrayList<>();
        if (intervals == null || newInterval == null) {
            return res;
        }

        int index = 0;
        while (index < intervals.size() && intervals.get(index).end < newInterval.start) {
            res.add(intervals.get(index));
            index++;
        }

        while (index < intervals.size() && intervals.get(index).start <= newInterval.end) {
            newInterval.start = Math.min(intervals.get(index).start, newInterval.start);
            newInterval.end = Math.max(intervals.get(index).end, newInterval.end);
            index++;
        }

        res.add(newInterval);
        
        while (index < intervals.size()) {
            res.add(intervals.get(index));
            index++;
        }
        
        return res;
    }
}