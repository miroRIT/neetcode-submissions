class Solution {
    private List<List<Integer>> res;
    private List<Integer> path;

    public List<List<Integer>> combine(int n, int k) {
        res = new ArrayList<>();
        path = new ArrayList<>();
        dfs(1, res, path, n, k);
        return res;
    }

    private void dfs(int s, List<List<Integer>> res, List<Integer> path, int n, int k) {
        if (path.size() == k) {
            res.add(new ArrayList<>(path));
            return;
        }

        if (s > n)
            return;

        for (int i = s; i < n + 1; i++) {
            path.add(i);
            dfs(i + 1, res, path, n, k);
            path.remove(path.size() - 1);
        }
    }
}