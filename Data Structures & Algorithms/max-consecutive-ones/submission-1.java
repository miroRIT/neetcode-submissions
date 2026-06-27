class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int max_num = 0, count = 0;
        for (int elem : nums){
            if (elem == 1){
                count++;
            }else{
                count = 0;
            }
            max_num = Math.max(max_num, count);
        }   
        return max_num;
    }
}