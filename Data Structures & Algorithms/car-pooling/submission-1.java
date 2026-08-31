class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
        int l = Integer.MAX_VALUE, r = Integer.MIN_VALUE;
        for (int[] trip : trips) {
            l = Math.min(trip[1], l);
            r = Math.max(trip[2], r);
        }

        int n = r - l + 1;
        int[] passChange = new int[n];

        for (int[] trip : trips) {
            passChange[trip[1] - l] += trip[0];
            passChange[trip[2] - l] -= trip[0];
        }

        int curPas = 0;

        for (int change : passChange) {
            curPas += change;
            if (curPas > capacity)
                return false;
        }

        return true;
    }
}