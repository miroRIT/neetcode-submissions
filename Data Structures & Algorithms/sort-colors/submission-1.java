class Solution {
    public void sortColors(int[] nums) {
        int one = 0, zero = 0;

        for (int two = 0; two < nums.length; two++){
            int tmp = nums[two];
            nums[two] = 2;
            if (tmp < 2)
                nums[one++] = 1;
            if (tmp < 1)
                nums[zero++] = 0;
        }
    }
}