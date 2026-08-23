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

        res += word1[i:]
        res += word2[j:]

        return res