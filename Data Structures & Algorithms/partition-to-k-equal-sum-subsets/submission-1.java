class Solution {
    private int target, n;

    public boolean canPartitionKSubsets(int[] nums, int k) {
        int total = Arrays.stream(nums).sum();
        n = nums.length;
        target = total / k;
        Arrays.sort(nums);
        reverse(nums);
        return backtrack(0, k, 0, (1 << n) - 1, nums);
    }

    private boolean backtrack(int i, int k, int ssSum, int mask, int[] nums) {
        if (k == 0)
            return true;

        if (ssSum == target)
            return backtrack(0, k - 1, 0, mask, nums);

        for (int j = i; j < n; j++) {
            if ((mask & (1 << j)) == 0 || ssSum + nums[j] > target)
                continue;

            if (backtrack(j + 1, k, ssSum + nums[j], mask ^ (1 << j), nums))
                return true;

            if (ssSum == 0)
                return false;
        }
        return false;
    }

    private void reverse(int[] nums) {
        for (int i = 0, j = n - 1; i < j; j--, i++) {
            int tmp = nums[i];
            nums[i] = nums[j];
            nums[j] = tmp;
        }
    }
}