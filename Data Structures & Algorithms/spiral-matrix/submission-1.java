class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        int l = 0, top = 0;
        int bottom = matrix.length, r = matrix[0].length;
        List<Integer> res = new ArrayList<>();
        while (l < r && top < bottom) {
            for (int i = l; i < r; i++)
                res.add(matrix[top][i]);
            top++;
            for (int i = top; i < bottom; i++)
                res.add(matrix[i][r - 1]);
            r--;
            if (!(l < r && top < bottom))
                break;
            for (int i = r - 1; i > l - 1; i--)
                res.add(matrix[bottom - 1][i]);
            bottom--;
            for (int i = bottom - 1; i > top - 1; i--)
                res.add(matrix[i][l]);
            l++;
        }
        return res;
    }
}
