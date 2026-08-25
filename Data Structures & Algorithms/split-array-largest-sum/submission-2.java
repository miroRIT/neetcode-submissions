class Solution {
    public int splitArray(int[] nums, int k) {
        int l = Integer.MIN_VALUE, r = 0;

        for (int num : nums) {
            l = Math.max(l, num);
            r += num;
        }

        int res = r;

        while (l <= r) {
            int m = l + (r - l) / 2;

            if (canSplit(nums, k, m)) {
                res = m;
                r = m - 1;
            } else {
                l = m + 1;
            }
        }

        return res;
    }

    private boolean canSplit(int[] nums, int k, int max) {
        int split = 1, curSum = 0;

        for (int num : nums) {
            curSum += num;
            if (curSum > max) {
                split++;
                if (split > k)
                    return false;
                curSum = num;
            }
        }

        return true;
    }
}