class Solution:
    def findMaxConsecutiveOnes(self, nums: List[int]) -> int:
        max_num = count = 0
        for elem in nums:
            if elem == 1:
                count += 1
            else:
                count = 0
            max_num = max(max_num, count)
        return max_num        