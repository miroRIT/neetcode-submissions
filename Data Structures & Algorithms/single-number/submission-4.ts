class Solution {
    /**
     * @param {number[]} nums
     * @return {number}
     */
    singleNumber(nums: number[]): number {
        let res = 0;
        for (let elem of nums) res ^= elem;
        return res;
    }
}
