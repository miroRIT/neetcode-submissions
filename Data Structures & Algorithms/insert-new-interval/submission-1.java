class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int n = intervals.length;
        if (n == 0)
            return new int[][] {newInterval};

        int target = newInterval[0], l = 0, r = n - 1;

        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (intervals[mid][0] < target)
                l = mid + 1;
            else
                r = mid - 1;
        }

        List<int[]> res = new ArrayList<>();
        for (int i = 0; i < l; i++) res.add(intervals[i]);
        res.add(newInterval);
        for (int i = l; i < n; i++) res.add(intervals[i]);

        List<int[]> merged = new ArrayList<>();
        for (int[] interval : res) {
            if (merged.isEmpty() || merged.get(merged.size() - 1)[1] < interval[0])
                merged.add(interval);
            else {
                merged.get(merged.size() - 1)[1] =
                    Math.max(merged.get(merged.size() - 1)[1], interval[1]);
            }
        }
        return merged.toArray(new int[0][]);
    }
}
