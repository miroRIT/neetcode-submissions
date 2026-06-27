class Solution {
    /**
     * @param {number[]} nums
     * @param {number} target
     * @return {number[]}
     */
    twoSum(nums: number[], target: number): number[] {// Create a map to store the value and its index
        const prevMap = new Map();

        for (let i = 0; i < nums.length; i++) {
            const diff = target - nums[i];

            // If the complement exists in the map, we found the pair
            if (prevMap.has(diff)) {
                return [prevMap.get(diff), i];
            }

            // Otherwise, add the current number and index to the map
            prevMap.set(nums[i], i);
        }
    }
}
