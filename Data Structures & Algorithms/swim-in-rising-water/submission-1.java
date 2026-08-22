class Solution {
    public int swimInWater(int[][] grid) {
        int n = grid.length;
        boolean[][] visited = new boolean[n][n];
        PriorityQueue<int[]> q = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        int[][] directions = { {0, 1}, {1, 0}, {-1, 0}, {0, -1}};
        visited[0][0] = true;
        q.offer(new int[]{grid[0][0], 0, 0});

        while (!q.isEmpty()){
            int[] cur = q.poll();
            int t = cur[0], r = cur[1], c = cur[2];
            if (r == n - 1 && c == n - 1) return t;

            for (int[] dir : directions){
                int neiR = r + dir[0], neiC = c + dir[1];
                if (neiR >= 0 && neiC >= 0 && neiR < n && neiC < n && !visited[neiR][neiC]){
                    visited[neiR][neiC] = true;
                    q.offer(new int[] {Math.max(t, grid[neiR][neiC]), neiR, neiC});
                }
            }
        }
        return n * n;
    }
}
