class Solution {
    public int maxProduct(int[] nums) {
        int res = nums[0], curMax = 1, curMin = 1;

        for (int num : nums){
            int t1 = curMax * num;
            int t2 = curMin * num;
            curMax = Math.max(Math.max(num, t1), t2);
            curMin = Math.min(Math.min(num, t1), t2);
            res = Math.max(res, curMax);
        }

        return res;
    }
}
