class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        i = 0
        j = 1
        while (i < len(nums)):
            if (j == len(nums)):
                i += 1
                j = i + 1
            else:
                if ((nums[i] + nums[j]) == target):
                    return [i, j]
                j +=1
        