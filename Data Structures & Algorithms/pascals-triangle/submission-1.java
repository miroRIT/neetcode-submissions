class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < numRows; i++){
            List<Integer> curr_row = new ArrayList<>();
            for (int k = 0; k <= i; k++) {
                curr_row.add(1);
            }
            // Calculate middle values
            for (int j = 1; j < i; j++) {
                int sum = res.get(i - 1).get(j - 1) + res.get(i - 1).get(j);
                curr_row.set(j, sum);
            }
            res.add(curr_row);
        }
        return res;
    }
}