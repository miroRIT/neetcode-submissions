class Solution {
    /**
     * @param {number[]} nums
     * @param {number} k
     * @return {number[]}
     */
    topKFrequent(nums, k) {
        let res = new Map()
        for (let i of nums)
            res.set(i, (res.get(i) || 0) + 1)
        let sorted_keys = [... res.entries()].sort((a, b) => b[1] - a[1]).map(entry => entry[0])
        return sorted_keys.slice(0, k)
    }
}
