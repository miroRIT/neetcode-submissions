class Solution {
    /**
     * @param {number[]} nums
     * @return {number[]}
     */
    productExceptSelf(nums) {
        let prefix = 1,
            n = nums.length;
        let res = new Array(n).fill(1);
        for (let i = 0; i < n; i++) {
            res[i] = prefix;
            prefix *= nums[i];
        }
        prefix = 1;
        for (let i = n - 1; i >= 0; i--) {
            res[i] *= prefix;
            prefix *= nums[i];
        }
        return res;
    }
}
