class Solution {
    List<String> res = new ArrayList<>();
    public List<String> generateParenthesis(int n) {
        backtrack(0, 0, n, new StringBuilder());
        return res;
    }

    private void backtrack(int open, int close, int n, StringBuilder stack){
        if (open == close && open == n){
            res.add(stack.toString());
            return;
        }

        if (open < n){
            stack.append('(');
            backtrack(open + 1, close, n, stack);
            stack.deleteCharAt(stack.length() - 1);
        }
        if (close < open){
            stack.append(')');
            backtrack(open, close + 1, n, stack);
            stack.deleteCharAt(stack.length() - 1);
        }
    }
}