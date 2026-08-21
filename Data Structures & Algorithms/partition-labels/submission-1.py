class Solution:
    def partitionLabels(self, s: str) -> List[int]:
        lastIndex = {}
        for i in range(len(s)):
            lastIndex[s[i]] = i
        
        res = []
        size, end = 0, 0

        for i in range(len(s)):
            size += 1
            end = max(end, lastIndex[s[i]])

            if i == end:
                res.append(size)
                size = 0
        
        return res