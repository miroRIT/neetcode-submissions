class Solution:
    def search(self, nums: List[int], target: int) -> int:
        l, r = 0, len(nums) - 1
        
        while l < r:
            m = (l + r) // 2
            if nums[m] < nums[r]:
                r = m
            else:
                l = m + 1
        pivot = l

        def binary(left: int, right: int) -> int:
            while left <= right:
                m = (left + right) // 2
                if target == nums[m]:
                    return m
                elif target > nums[m]:
                    left = m + 1
                else:
                    right = m - 1
            return -1
        
        result = binary(0, pivot - 1) 
        if result != -1:
            return result
        return binary(pivot, len(nums) - 1)