class Solution:
    def stringMatching(self, words: List[str]) -> List[str]:
        res = []
        words.sort(key = len)
        n = len(words)
        for i in range(n - 1):
            for j in range (i + 1, n):
                if words[i] in words[j]:
                    res.append(words[i])
                    break
        return res