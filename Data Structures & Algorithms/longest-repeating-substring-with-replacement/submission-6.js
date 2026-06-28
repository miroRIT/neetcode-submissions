class Solution {
    /**
     * @param {string} s
     * @param {number} k
     * @return {number}
     */
    characterReplacement(s, k) {
        let map = new Map();
        let left = 0, max_len = 0, max_freq = 0;
        for (let right = 0; right < s.length; right++){
            map.set(s[right], (map.get(s[right]) || 0) + 1)
            max_freq = Math.max(max_freq, map.get(s[right]))
            while ((right - left + 1 - max_freq) > k){
                map.set(s[left] ,map.get(s[left]) - 1)
                left++
            }
            max_len = Math.max(right - left + 1, max_len)
        }
        return max_len
    }
}
