class Solution:
    def topKFrequent(self, nums: List[int], k: int) -> List[int]:
        res = {}
        for elem in nums:
            res[elem] = res.get(elem, 0) +1
        sort_res = sorted(res.items(), key = lambda item: item[1], reverse = True)
        return [item[0] for item in sort_res[:k]]