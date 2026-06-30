class Solution {
    public int longestConsecutive(int[] nums) {
        int streak = 0;
        Set<Integer> num_set = new HashSet<>();

        for (int num : nums) {
            num_set.add(num);
        }
        for (int num : nums) {
            if (!num_set.contains(num - 1)) {
                int curr = num;
                int curr_streak = 1;

                while (num_set.contains(curr + 1)) {
                    curr++;
                    curr_streak++;
                }
                streak = Math.max(streak, curr_streak);
            }
        }
        return streak;
    }
}