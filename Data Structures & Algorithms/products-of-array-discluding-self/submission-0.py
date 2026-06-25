class Solution:
    def productExceptSelf(self, nums: List[int]) -> List[int]:
        output = []
        i = j = 0
        while i < len(nums):
            num = 1
            while j < len(nums):
                if i != j:
                    num *= nums[j]
                j += 1
            output.append(num)
            i += 1
            j = 0
        return output
