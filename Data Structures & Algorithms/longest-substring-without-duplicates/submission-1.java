class Solution {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> charset = new HashSet<>();
        int left = 0, max_len = 0;
        for (int right = 0; right < s.length(); right++){
            while (charset.contains(s.charAt(right))){
                charset.remove(s.charAt(left));
                left++;
            }
            charset.add(s.charAt(right));
            max_len = Math.max(max_len, right - left + 1);
        }
        return max_len;
    }
}
