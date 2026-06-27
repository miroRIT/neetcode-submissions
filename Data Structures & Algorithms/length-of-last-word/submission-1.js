class Solution {
    /**
     * @param {string} s
     * @return {number}
     */
    lengthOfLastWord(s) {
        let arr = s.trim().split(" ")
        return arr[arr.length - 1].length
    }
}
