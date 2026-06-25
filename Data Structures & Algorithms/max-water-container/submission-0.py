class Solution:
    def maxArea(self, heights: List[int]) -> int:
        left, right = 0, len(heights) - 1
        max_water = 0

        while left < right:
            # Calculate current area
            width = right - left
            curr_height = min(heights[left], heights[right])
            max_water = max(max_water, width * curr_height)

            # Move the pointer with smaller height
            if heights[left] < heights[right]:
                left += 1
            else:
                right -= 1

        return max_water
        