class Solution {
    private int count, n, posDiag, negDiag, col;
    public int totalNQueens(int n) {
        this.n = n;
        count = posDiag = negDiag = col = 0;
        backtrack(0);
        return count;
    }

    private void backtrack(int r) {
        if (r == n)
            count++;
        else {
            for (int c = 0; c < n; c++) {
                int pos = (r + c), neg = (r - c + n);
                if ((col & (1 << c)) > 0 || (posDiag & (1 << pos)) > 0 || (negDiag & (1 << neg)) > 0)
                    continue;

                col ^= (1 << c);
                posDiag ^= (1 << pos);
                negDiag ^= (1 << neg);
                backtrack(r + 1);
                col ^= (1 << c);
                posDiag ^= (1 << pos);
                negDiag ^= (1 << neg);
            }
        }
    }
}