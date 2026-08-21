class Solution:
    def partitionLabels(self, s: str) -> List[int]:
        lastIndex = {}
        for i, c in enumerate(s):
            lastIndex[c] = i
        
        res = []
        l, maxReach = 0, 0

        for i, c in enumerate(s):
            maxReach = max(maxReach, lastIndex[c])

            if i == maxReach:
                res.append(i - l + 1)
                l = i + 1
        
        return res