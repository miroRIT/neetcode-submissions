class Solution:
    def insert(self, intervals: List[List[int]], newInterval: List[int]) -> List[List[int]]:
        n = len(intervals)
        if n == 0:
            return [newInterval]
        target = newInterval[0]
        l, r = 0, n - 1

        while l <= r:
            mid = (l + r) // 2
            if intervals[mid][0] < target: l = mid + 1
            else: r = mid - 1
        
        intervals.insert(l, newInterval)

        res = []
        for interval in intervals:
            if not res or res[-1][1] < interval[0]: res.append(interval)
            else: res[-1][1] = max(res[-1][1], interval[1])
        
        return res