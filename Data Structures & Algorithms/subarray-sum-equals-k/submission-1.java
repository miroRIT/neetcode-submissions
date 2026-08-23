class Solution {
    public int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> prefixSum = new HashMap<>();
        int res = 0, curSum = 0;
        prefixSum.put(0, 1);

        for (int num : nums) {
            curSum += num;
            int dif = curSum - k;
            res += prefixSum.getOrDefault(dif, 0);
            prefixSum.put(curSum, prefixSum.getOrDefault(curSum, 0) + 1);
        }

        return res;
    }
}