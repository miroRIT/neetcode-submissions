class Solution:
    def subsetsWithDup(self, nums: List[int]) -> List[List[int]]:
        nums.sort()
        res = [[]]
        pId = Id = 0

        for i in range(len(nums)):
            Id = pId if i >= 1 and nums[i] == nums[i - 1] else 0

            pId = len(res)
            for j in range(Id, pId):
                tmp = res[j].copy()
                tmp.append(nums[i])
                res.append(tmp)

        return res
