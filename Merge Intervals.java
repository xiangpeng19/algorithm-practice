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

}