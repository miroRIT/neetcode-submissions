class Solution {
    /**
     * @param {number[]} nums
     * @param {number} k
     * @return {number[]}
     */
    topKFrequent(nums: number[], k: number): number[] {
        let res: Map<number, number> = new Map()
        nums.forEach(i => res.set(i, (res.get(i) || 0) + 1))
        return Array.from(res.entries()).sort((a, b) => b[1] - a[1]).map(([num]) => num).slice(0, k)
    }
}
