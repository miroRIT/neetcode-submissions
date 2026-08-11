class Solution {
    public int[][] merge(int[][] intervals) {
        int max = 0;
        for (int i = 0; i < intervals.length; i++) max = Math.max(max, intervals[i][0]);

        int[] mp = new int[max + 1];
        for (int i = 0; i < intervals.length; i++) {
            int s = intervals[i][0];
            int e = intervals[i][1];
            mp[s] = Math.max(e + 1, mp[s]);
        }

        int have = -1, interval_start = -1, r = 0;
        for (int i = 0; i < mp.length; i++) {
            if (mp[i] != 0) {
                if (interval_start == -1)
                    interval_start = i;
                have = Math.max(have, mp[i] - 1);
            }
            if (have == i) {
                intervals[r++] = new int[] {interval_start, have};
                have = -1;
                interval_start = -1;
            }
        }
        if (interval_start != -1)
            intervals[r++] = new int[] {interval_start, have};

        if (intervals.length == r)
            return intervals;

        int[][] res = new int[r][];
        for (int i = 0; i < r; i++) res[i] = intervals[i];
        return res;
    }
}
