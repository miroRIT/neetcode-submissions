class Solution {
    private boolean[] visited;
    private List<List<Integer>> adj;
    private Set<Integer> cycle;
    private int cycleStart;

    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        adj = new ArrayList<>();
        for (int i = 0; i <= n; i++) adj.add(new ArrayList<>());

        for (int[] edge : edges) {
            int u = edge[0], v = edge[1];
            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        visited = new boolean[n + 1];
        cycle = new HashSet<>();
        cycleStart = -1;
        dfs(1, -1);

        for (int i = n - 1; i >= 0; i--) {
            int u = edges[i][0], v = edges[i][1];
            if (cycle.contains(u) && cycle.contains(v))
                return new int[] {u, v};
        }
        return new int[0];
    }

    private boolean dfs(int node, int par) {
        if (visited[node]) {
            cycleStart = node;
            return true;
        }
        visited[node] = true;
        for (int nei : adj.get(node)) {
            if (nei == par)
                continue;
            if (dfs(nei, node)) {
                if (cycleStart != -1)
                    cycle.add(nei);
                if (node == cycleStart)
                    cycleStart = -1;
                return true;
            }
        }
        return false;
    }
}
