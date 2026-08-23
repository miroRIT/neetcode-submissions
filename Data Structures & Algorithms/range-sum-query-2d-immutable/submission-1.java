class NumMatrix {
    private int[][] sumMat;

    public NumMatrix(int[][] matrix) {
        int rows = matrix.length, cols = matrix[0].length;
        sumMat = new int[rows + 1][cols + 1];

        for (int r = 0; r < rows; r++) {
            int pre = 0;
            for (int c = 0; c < cols; c++) {
                pre += matrix[r][c];
                int a = sumMat[r][c + 1];
                sumMat[r + 1][c + 1] = pre + a;
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        row2++;
        col2++;
        int br = sumMat[row2][col2];
        int tr = sumMat[row1][col2];
        int tl = sumMat[row1][col1];
        int bl = sumMat[row2][col1];

        return br + tl - bl - tr;
    }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */