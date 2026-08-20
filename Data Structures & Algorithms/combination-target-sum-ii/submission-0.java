class Solution {
    List<List<Integer>> res;
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        res = new ArrayList<>();
        dfs(0, new ArrayList<>(), 0, candidates, target);
        return res;
    }

    private void dfs(int i, List<Integer> cur, int curSum, int[] candidates, int target){
        if (target == curSum){
            res.add(new ArrayList<>(cur));
            return;
        }

        for (int j = i; j < candidates.length; j++){
            if (j > i && candidates[j] == candidates[j - 1])
                continue;
            if (curSum + candidates[j] > target)
                break;
            
            cur.add(candidates[j]);
            dfs(j + 1, cur, curSum + candidates[j], candidates, target);
            cur.remove(cur.size() - 1);
        }
    }
}
