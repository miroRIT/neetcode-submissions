class Solution {
    /**
     * @param {number[]} stones
     * @return {number}
     */
    lastStoneWeight(stones: number[]): number {
        let n = stones.length
        if (n == 0) return 0
        if(n == 1) return stones[0]
        stones.sort((a, b) => a - b)
        let i0 = stones.pop()
        let i1 = stones.pop()
        if (i0 != i1) stones.push(i0 - i1)
        return this.lastStoneWeight(stones)
    }
}
