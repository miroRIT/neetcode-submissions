class Solution {
    /**
     * @param {string} s
     * @return {number}
     */
    lengthOfLongestSubstring(s) {
        let charSet = new Set()
        let max_len = 0, left = 0
        for (let right = 0; right < s.length; right++){
            while (charSet.has(s.charAt(right))){
                charSet.delete(s.charAt(left));
                left++
            }
            charSet.add(s.charAt(right))
            max_len = Math.max(max_len, right - left + 1)
        }
        return max_len
    }
}
