/**
 * Definition of Interval:
 * public class Interval {
 *     public int start, end;
 *     public Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 * }
 */

class Solution {
    public boolean canAttendMeetings(List<Interval> intervals) {
        int n = intervals.size();
        if (n == 0 || n == 1) return true;
        intervals.sort((m1, m2) -> Integer.compare(m1.start, m2.start));
        for (int i = 1; i < n; i++){
            if (intervals.get(i).start < intervals.get(i - 1).end) return false;
        }
        return true;
    }
}
