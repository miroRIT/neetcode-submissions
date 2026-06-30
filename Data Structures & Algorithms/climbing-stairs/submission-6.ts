class Solution {
    /**
     * @param {number} n
     * @return {number}
     */
    climbStairs(n: number): number {
        let one: number = 1,
            two: number = 1;

        for (let i: number = 1; i < n; i++) [one, two] = [one + two, one];

        return one;
    }
}
