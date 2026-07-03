class Solution {
    public int search(int[] nums, int target) {
        int l = 0, r = nums.length - 1;

        while (l < r) {
            int m = l + (r - l) / 2;
            if (nums[m] > nums[r])
                l = m + 1;
            else
                r = m;
        }
        int res = binary(nums, 0, l - 1, target);
        if (res != -1)
            return res;
        return binary(nums, l, nums.length - 1, target);
    }

    private int binary(int[] nums, int left, int right, int target) {
        while (left <= right) {
            int m = left + (right - left) / 2;
            if (target == nums[m])
                return m;
            else if (target > nums[m])
                left = m + 1;
            else
                right = m - 1;
        }
        return -1;
    }
}
