class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        int n = nums.length;
        List<List<Integer>> res = new ArrayList<>();
        Map<Integer, Integer> freq = new HashMap<>();

        for (int num : nums) freq.put(num, freq.getOrDefault(num, 0) + 1);

        for (int i = 0; i < n; i++) {
            freq.put(nums[i], freq.get(nums[i]) - 1);
            if (i > 0 && nums[i] == nums[i - 1])
                continue;

            for (int j = i + 1; j < n; j++) {
                freq.put(nums[j], freq.get(nums[j]) - 1);
                if (j > i + 1 && nums[j] == nums[j - 1])
                    continue;

                for (int k = j + 1; k < n; k++) {
                    freq.put(nums[k], freq.get(nums[k]) - 1);
                    if (k > j + 1 && nums[k] == nums[k - 1])
                        continue;

                    long fourth = target - (nums[i] + nums[j] + 0L + nums[k]);
                    if (fourth > Integer.MAX_VALUE || fourth < Integer.MIN_VALUE)
                        continue;

                    if (freq.getOrDefault((int) fourth, 0) > 0)
                        res.add(Arrays.asList(nums[i], nums[j], nums[k], (int) fourth));
                }

                for (int k = j + 1; k < n; k++) freq.put(nums[k], freq.get(nums[k]) + 1);
            }

            for (int j = i + 1; j < n; j++) freq.put(nums[j], freq.get(nums[j]) + 1);
        }

        return res;
    }
}