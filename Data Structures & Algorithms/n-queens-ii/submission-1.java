class Solution {
    private int count = 0, n;
    private boolean[] col, posDiag, negDiag;
    public int totalNQueens(int n) {
        this.n = n;
        col = new boolean[n];
        posDiag = new boolean[2 * n];
        negDiag = new boolean[2 * n];
        backtrack(0);
        return count;
    }

    private void backtrack(int r) {
        if (r == n) {
            count++;
            return;
        }

        for (int c = 0; c < n; c++) {
            if (col[c] || posDiag[r + c] || negDiag[r - c + n])
                continue;

            col[c] = posDiag[r + c] = negDiag[r - c + n] = true;
            backtrack(r + 1);
            col[c] = posDiag[r + c] = negDiag[r - c + n] = false;
        }
    }
}