class Solution {
    public int maxArea(int[] heights) {
        int n = heights.length;
        int maxAr = 0, l = 0, r = n - 1;

        while (l < r){
            int min = Math.min(heights[r], heights[l]);
            maxAr = Math.max(maxAr, (r - l) * min);
            if (min == heights[r]) r--;
            else l++;
        }
        return maxAr;
    }
}
