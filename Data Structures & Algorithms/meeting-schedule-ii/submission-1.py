"""
Definition of Interval:
class Interval(object):
    def __init__(self, start, end):
        self.start = start
        self.end = end
"""

class Solution:
    def minMeetingRooms(self, intervals: List[Interval]) -> int:
        n = len(intervals)
        if n == 0 or n == 1:
            return n
        time = []
        for i in intervals:
            time.append([i.start, 1])
            time.append([i.end, -1])
        
        time.sort(key = lambda x: (x[0], x[1]))

        res = count = 0
        for t, c in time:
            count += c
            res = max(res, count)
        
        return res
        