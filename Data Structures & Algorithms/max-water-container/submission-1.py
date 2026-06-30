class Solution:
    def maxArea(self, heights: List[int]) -> int:
        n = len(heights)
        maxAr = 0
        l = 0
        r = n - 1
        
        while l < r:
            maxAr = max(maxAr, (r - l) * min(heights[l], heights[r]) )
            if heights[l] < heights[r]:
                l += 1
            else:
                r -=1
        return maxAr