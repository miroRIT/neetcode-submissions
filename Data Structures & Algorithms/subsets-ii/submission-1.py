class Solution:
    def subsetsWithDup(self, nums: List[int]) -> List[List[int]]:
        nums.sort()
        res = []

        def backtracking(path, startIndex):
            res.append(list(path))

            for i in range(startIndex, len(nums)):
                if i != startIndex and nums[i]==nums[i-1]:
                    continue

                num = nums[i]
                path.append(num)
                backtracking(path, i+1)
                path.pop()

        backtracking([], 0)
        return res
