class Solution {
    public int characterReplacement(String s, int k) {
        Map<Character, Integer> map = new HashMap<>();
        int left = 0, max_len = 0, max_freq = 0;
        for(int right = 0; right < s.length(); right++){
            char rightChar = s.charAt(right);
            map.put(rightChar, map.getOrDefault(rightChar, 0) + 1);
            max_freq = Math.max(max_freq, map.get(rightChar));
            while ((right - left + 1 - max_freq) > k){
                map.put(s.charAt(left), map.get(s.charAt(left)) - 1);
                left++;
            }
            max_len = Math.max(right - left + 1, max_len);
        }
        return max_len;
    }
}
