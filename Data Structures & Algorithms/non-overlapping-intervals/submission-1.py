class Solution:
    def eraseOverlapIntervals(self, intervals: List[List[int]]) -> int:
        intervals.sort()
        res, prevEnd = 0, intervals[0][1]

        for i in range(1, len(intervals)):
            s, e = intervals[i]
            if s >= prevEnd: prevEnd = e
            else:
                res += 1
                prevEnd = min(e, prevEnd)
        
        return res