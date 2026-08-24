class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int l = 0, curSum = 0;
        int minLen = Integer.MAX_VALUE;

        for (int r = 0; r < nums.length; r++){
            curSum += nums[r];
            while (curSum >= target){
                minLen = Math.min(minLen, r - l + 1);
                curSum -= nums[l++];
            }
        }
        return (minLen != Integer.MAX_VALUE) ? minLen : 0;
    }
}