class Solution:
    def merge(self, intervals: List[List[int]]) -> List[List[int]]:
        max_val =  max(interval[0] for interval in intervals)
        mp = [0] * (max_val + 1)
        for s, e in intervals:
            mp[s] = max(mp[s], e + 1)

        res = []
        interval_start, have = -1, -1
        for i in range(len(mp)):
            if mp[i] != 0:
                if interval_start == -1:
                    interval_start = i
                have = max(have, mp[i] - 1)

            if have == i:
                res.append([interval_start, have])
                interval_start, have = -1, -1

        if interval_start != -1:
            res.append([interval_start, have])

        return res
