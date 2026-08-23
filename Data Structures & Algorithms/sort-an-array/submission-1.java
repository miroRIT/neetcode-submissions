class Solution {
    public int[] sortArray(int[] nums) {
        counting_sort(nums);
        return nums;
    }
    public void counting_sort(int[] nums){
        HashMap<Integer, Integer> count = new HashMap<>();
        int minVal = nums[0], maxVal = nums[0];

        for (int num : nums){
            count.put(num, count.getOrDefault(num, 0) + 1);
            minVal = Math.min(minVal, num);
            maxVal = Math.max(maxVal, num);
        }

        int index = 0;
        for (int i = minVal; i <= maxVal; i++){
            while (count.getOrDefault(i, 0) > 0){
                nums[index++] = i;
                count.put(i, count.get(i) - 1);
            }
        }
    }
}