class Solution:
    def mergeAlternately(self, word1: str, word2: str) -> str:
        m = len(word1)
        n = len(word2)
        i = j = 0
        res = ""
        while i < m and j < n:
            res += word1[i] + word2[j]
            i += 1
            j += 1
        
        if i < m:
            res += word1[i:]

        if j < n:
            res += word2[j:]
        
        return res