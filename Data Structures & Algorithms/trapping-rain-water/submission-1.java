class Solution {
    public int trap(int[] height) {
        int area = 0, n = height.length;
        int[] l_max = new int[n];
        int[] r_max = new int[n];
        l_max[0] = height[0];
        r_max[n - 1] = height[n - 1];
        for (int i = 1; i < n; i++) {
            l_max[i] = Math.max(l_max[i - 1], height[i]);
        }
        for (int i = n - 2; i > -1; i--) {
            r_max[i] = Math.max(r_max[i + 1], height[i]);
        }
        for (int i = 0; i < n; i++){
            area += Math.min(l_max[i], r_max[i]) - height[i];
        }
        return area;
    }
}
