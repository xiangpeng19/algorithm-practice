/**
 * Definition of Interval:
 * public class Interval {
 *     int start, end;
 *     Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 */

class Solution {
    /**
     * @param intervals, a collection of intervals
     * @return: A new sorted interval list.
     */
    public List<Interval> merge(List<Interval> intervals) {
        // write your code here
        if (intervals == null || intervals.size() == 0) return intervals;
        Collections.sort(intervals, new Comparator<Interval>() {
            public int compare(Interval i1, Interval i2) {
                return i1.start - i2.start;
            }
        });
        List<Interval> res = new ArrayList<>();
        res.add(intervals.get(0));
        for (Interval cur : intervals) {
            Interval pre = res.get(res.size() - 1);
            merge(res, pre, cur);
        }

        return res;
    }

    private void merge(List<Interval> res, Interval pre, Interval cur) {
        if (pre.end < cur.start) {
            res.add(cur);
        } else if (pre.end < cur.end && pre.end >= cur.start) {
            res.remove(res.size() - 1);
            res.add(new Interval(pre.start, cur.end));
        }
    }

    public List<Interval> merge(List<Interval> intervals) {
        if (intervals.size() <= 1)
            return intervals;
        
        // Sort by ascending starting point using an anonymous Comparator
        intervals.sort((i1, i2) -> Integer.compare(i1.start, i2.start));
        
        List<Interval> result = new LinkedList<Interval>();
        int start = intervals.get(0).start;
        int end = intervals.get(0).end;
        
        for (Interval interval : intervals) {
            if (interval.start <= end) // Overlapping intervals, move the end if needed
                end = Math.max(end, interval.end);
            else {                     // Disjoint intervals, add the previous one and reset bounds
                result.add(new Interval(start, end));
                start = interval.start;
                end = interval.end;
            }
        }
        
        // Add the last interval
        result.add(new Interval(start, end));
        return result;
    }

    public List<Interval> merge(List<Interval> intervals) {
        List<Interval> res = new ArrayList<>();
        if (intervals == null || intervals.size() == 0) {
            return res;
        }

        Collections.sort(intervals, Comparator.comparingInt(o -> o.start));
        res.add(intervals.get(0));

        for (Interval i : intervals) {
            Interval last = res.get(res.size() - 1);
            if (last.end >= i.start) {
                last.end = Math.max(last.end, i.end);
            } else {
                res.add(i);
            }
        }
        return res;
    }

}