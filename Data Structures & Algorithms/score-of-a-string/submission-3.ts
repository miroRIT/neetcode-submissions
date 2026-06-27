class Solution {
    /**
     * @param {string} s
     * @return {number}
     */
    scoreOfString(s: string): number {
        let res = 0
        for (let i = 1; i < s.length; i++)
            res += Math.abs(s.charCodeAt(i) - s.charCodeAt(i - 1));
        return res
    }
}
