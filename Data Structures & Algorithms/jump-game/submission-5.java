class Solution {
    public boolean canJump(int[] nums) {
        int maxReach = 0;
        for (int i = 0; i < nums.length; i++) {
            // If the current index is beyond our max reach, we are stuck
            if (i > maxReach) {
                return false;
            }
            
            // Update the furthest index we can reach
            maxReach = Math.max(maxReach, i + nums[i]);
            
            // Optimization: If we can already reach the end, return true
            if (maxReach >= nums.length - 1) {
                return true;
            }
        }        
        return true;
    }
}
