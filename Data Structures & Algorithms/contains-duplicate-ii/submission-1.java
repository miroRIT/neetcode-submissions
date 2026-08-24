class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        int l = 0;
        Set<Integer> visited = new HashSet<>();

        for (int r = 0; r < nums.length; r++) {
            if (r - l > k)
                visited.remove(nums[l++]);

            if (visited.contains(nums[r]))
                return true;

            visited.add(nums[r]);
        }

        return false;
    }
}