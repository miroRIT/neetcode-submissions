class Solution {
    /**
     * @param {number[]} nums
     * @return {number}
     */
    missingNumber(nums) {
        let sum = 0;
        let n = nums.length;
        let ex = n * (n + 1) / 2
        for (let i of nums)
            sum += i
        return ex - sum
    }
}
