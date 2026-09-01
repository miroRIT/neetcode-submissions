class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        int gmax = nums[0], cmax = 0, cmin = 0, tot = 0, gmin = nums[0];
        for (int num : nums) {
            cmax = Math.max(cmax + num, num);
            gmax = Math.max(gmax, cmax);
            cmin = Math.min(cmin + num, num);
            gmin = Math.min(gmin, cmin);
            tot += num;
        }

        return gmax > 0 ? Math.max(gmax, tot - gmin) : gmax;
    }
}