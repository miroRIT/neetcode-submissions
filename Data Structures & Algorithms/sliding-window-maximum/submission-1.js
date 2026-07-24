class Solution {
    /**
     * @param {number[]} nums
     * @param {number} k
     * @return {number[]}
     */
    maxSlidingWindow(nums, k) {
        let n = nums.length;
        let res = [];
        let deque = [];

        for (let i = 0; i < n; i++) {
            if (deque.length > 0 && deque[0] < i - k + 1) deque.shift();

            while (deque.length > 0 && nums[deque[deque.length - 1]] < nums[i]) deque.pop();

            deque.push(i);

            if (i >= k - 1) res.push(nums[deque[0]]);
        }
        return res;
    }
}
