class Solution:
    def isAnagram(self, s: str, t: str) -> bool:
        if len(s) != len(t):
            return False
        
        freq_map = {}

        for i in range(len(s)):
            freq_map[s[i]] = freq_map.get(s[i], 0) + 1
            freq_map[t[i]] = freq_map.get(t[i], 0) - 1
        
        for elem in freq_map.keys():
            if freq_map[elem] != 0:
                return False
        
        return True