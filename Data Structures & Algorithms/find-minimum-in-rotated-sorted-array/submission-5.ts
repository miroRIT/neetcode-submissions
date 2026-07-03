class Solution {
    /**
     * @param {number[]} nums
     * @return {number}
     */
    findMin(nums: number[]): number {
        let l: number = 0,
            r: number = nums.length - 1,
            res: number = nums[0];

        while (l <= r) {
            if (nums[l] < nums[r]) {
                res = Math.min(res, nums[l]);
                break;
            }
            let m: number = Math.floor(l + (r - l) / 2);
            res = Math.min(res, nums[m]);
            if (nums[m] >= nums[l]) l = m + 1;
            else r = m - 1;
        }
        return res;
    }
}
