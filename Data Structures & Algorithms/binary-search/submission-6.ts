class Solution {
    /**
     * @param {number[]} nums
     * @param {number} target
     * @return {number}
     */
    search(nums: number[], target: number): number {
        let left = 0, right = nums.length - 1;
        while (left <= right){
            let mid = Math.floor(left + (right - left) / 2)
            if (target === nums[mid]) return mid
            if (target > nums[mid]) left = mid + 1
            else right = mid - 1
        }
        return -1
    }
}
