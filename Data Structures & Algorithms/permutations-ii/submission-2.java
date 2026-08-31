class Solution {
    private List<List<Integer>> res;

    public List<List<Integer>> permuteUnique(int[] nums) {
        res = new ArrayList<>();
        Arrays.sort(nums);
        dfs(nums, 0);
        return res;
    }

    private void dfs(int[] nums, int i) {
        if (i == nums.length) {
            res.add(Arrays.stream(nums).boxed().collect(Collectors.toList()));
            return;
        }

        for (int j = i; j < nums.length; j++) {
            if (j > i && nums[j] == nums[i])
                continue;

            swap(nums, i, j);
            dfs(nums, i + 1);
        }

        for (int j = nums.length - 1; j > i; j--) swap(nums, i, j);
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}