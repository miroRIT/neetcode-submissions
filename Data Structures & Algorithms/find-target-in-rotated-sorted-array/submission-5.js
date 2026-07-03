class Solution {
    /**
     * @param {number[]} nums
     * @param {number} target
     * @return {number}
     */
    search(nums, target) {
        let l = 0,
            r = nums.length - 1;
        while (l < r) {
            let m = Math.floor((r + l) / 2);
            if (nums[m] > nums[r]) l = m + 1;
            else r = m;
        }

        function binary(left, right) {
            while (left <= right) {
                let m = Math.floor((right + left) / 2);
                if (nums[m] === target) return m;
                else if (nums[m] > target) right = m - 1;
                else left = m + 1;
            }
            return -1;
        }
        let res = binary(0, l - 1);
        if (res !== -1) return res;
        return binary(l, nums.length - 1);
    }
}
