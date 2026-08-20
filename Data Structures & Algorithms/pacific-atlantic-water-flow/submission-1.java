class Solution {
    private int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int rows = heights.length, cols = heights[0].length;
        boolean[][] pac = new boolean[rows][cols];
        boolean[][] alt = new boolean[rows][cols];

        Queue<int[]> pacQueue = new LinkedList<>();
        Queue<int[]> altQueue = new LinkedList<>();

        for (int c = 0; c < cols; c++) {
            pacQueue.add(new int[] {0, c});
            altQueue.add(new int[] {rows - 1, c});
        }

        for (int r = 0; r < rows; r++) {
            pacQueue.add(new int[] {r, 0});
            altQueue.add(new int[] {r, cols - 1});
        }

        bfs(pacQueue, pac, heights);
        bfs(altQueue, alt, heights);

        List<List<Integer>> res = new ArrayList<>();
        for (int r = 0; r < rows; r++)
            for (int c = 0; c < cols; c++)
                if (pac[r][c] && alt[r][c])
                    res.add(Arrays.asList(r, c));

        return res;
    }

    private void bfs(Queue<int[]> q, boolean[][] ocean, int[][] heights) {
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int r = cur[0], c = cur[1];
            ocean[r][c] = true;
            for (int[] d : directions) {
                int nr = r + d[0], nc = c + d[1];
                if (nr >= 0 && nr < heights.length && nc >= 0 && nc < heights[0].length
                    && !ocean[nr][nc] && heights[nr][nc] >= heights[r][c])
                    q.add(new int[] {nr, nc});
            }
        }
    }
}
