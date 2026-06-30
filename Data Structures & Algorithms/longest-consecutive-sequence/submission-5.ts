class Solution {
    /**
     * @param {number[]} nums
     * @return {number}
     */
    longestConsecutive(nums: number[]): number {
        let streak = 0;
        let num_set = new Set(nums);

        for (let i of nums) {
            if (!num_set.has(i - 1)) {
                let curr = i;
                let curr_streak = 1;
                while (num_set.has(curr + 1)) {
                    curr++;
                    curr_streak++;
                }
                streak = Math.max(streak, curr_streak);
            }
        }
        return streak;
    }
}
