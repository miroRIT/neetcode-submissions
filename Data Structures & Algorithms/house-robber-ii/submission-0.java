class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        return Math.max(nums[0],
            Math.max(helper(Arrays.copyOfRange(nums, 1, n)),
                helper(Arrays.copyOfRange(nums, 0, n - 1))));
    }

    private int helper(int[] nums) {
        int rob1 = 0, rob2 = 0;

        for (int num : nums) {
            int temp = Math.max(num + rob1, rob2);
            rob1 = rob2;
            rob2 = temp;
        }

        return rob2;
    }
}
