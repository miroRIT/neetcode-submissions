class Solution {
    public void rotate(int[][] matrix) {
        reverse(matrix);
        for (int i = 0; i < matrix.length; i++){
            for (int j = i; j < matrix[i].length; j++){
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = tmp;
            }
        }
    }

    private void reverse(int[][] matrix){
        int n = matrix.length;
        for (int i = 0; i < n / 2; i++){
            int[] tmp = matrix[i];
            matrix[i] = matrix[n - i - 1];
            matrix[n - i - 1] = tmp;
        }
    }
}
