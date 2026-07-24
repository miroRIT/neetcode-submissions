class Solution {
    /**
     * @param {number[]} nums
     * @param {number} k
     * @return {number[]}
     */
    maxSlidingWindow(nums: number[], k: number): number[] {
        let n: number = nums.length;
        let res: number[] = [];
        let deque: number[] = [];

        for (let i: number = 0; i < n; i++) {
            if (deque.length > 0 && deque[0] < i - k + 1) deque.shift();

            while (deque.length > 0 && nums[deque[deque.length - 1]] < nums[i]) deque.pop();

            deque.push(i);

            if (i >= k - 1) res.push(nums[deque[0]]);
        }
        return res;}
}
