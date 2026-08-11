class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        int res = 0, prevEnd = intervals[0][1];
        for (int i = 1; i < intervals.length; i++){
            int s = intervals[i][0];
            int e = intervals[i][1];
            if (s >= prevEnd) prevEnd = e;
            else{
                res++;
                prevEnd = Math.min(e, prevEnd);
            }
        }
        return res;
    }
}
