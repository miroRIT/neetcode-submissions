class Solution {
    /**
     * @param {number[]} nums
     * @return {number[]}
     */
    productExceptSelf(nums: number[]): number[] {
        let prefix: number = 1,
            n: number = nums.length;
        let res: number[] = new Array(n).fill(1);
        for (let i: number = 0; i < n; i++) {
            res[i] = prefix;
            prefix *= nums[i];
        }
        prefix = 1;
        for (let i: number = n - 1; i >= 0; i--) {
            res[i] *= prefix;
            prefix *= nums[i];
        }
        return res;
    }
}
