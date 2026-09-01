class Solution {
    private List<Integer>[] adj;
    private int[][] isPre;

    public List<Boolean> checkIfPrerequisite(
        int numCourses, int[][] prerequisites, int[][] queries) {
        adj = new ArrayList[numCourses];
        isPre = new int[numCourses][numCourses];
        for (int i = 0; i < numCourses; i++) {
            adj[i] = new ArrayList<>();
            Arrays.fill(isPre[i], -1);
        }

        for (int[] pre : prerequisites) {
            adj[pre[1]].add(pre[0]);
            isPre[pre[1]][pre[0]] = 1;
        }

        List<Boolean> res = new ArrayList<>();
        for (int[] query : queries) res.add(dfs(query[1], query[0]));

        return res;
    }

    private boolean dfs(int crs, int pre) {
        if (isPre[crs][pre] != -1)
            return isPre[crs][pre] == 1;

        for (int p : adj[crs]) {
            if (p == pre || dfs(p, pre)) {
                isPre[crs][pre] = 1;
                return true;
            }
        }

        isPre[crs][pre] = 0;
        return false;
    }
}