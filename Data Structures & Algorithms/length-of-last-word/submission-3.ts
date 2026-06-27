class Solution {
    /**
     * @param {string} s
     * @return {number}
     */
    lengthOfLastWord(s: string): number {
        let arr = s.trim().split(" ")
        return arr.at(-1).length
    }
}
