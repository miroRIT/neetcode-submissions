class Solution {
    /**
     * @param {number[]} nums
     * @return {number}
     */
    findMaxConsecutiveOnes(nums: number[]): number {
        let max_num = 0, count = 0
        nums.forEach((item, index) => {
            if (item == 1){
                count++
            }else{
                count = 0
            }
            max_num = Math.max(count, max_num)
        });
        return max_num
    }
}
