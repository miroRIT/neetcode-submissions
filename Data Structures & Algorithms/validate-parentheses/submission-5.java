class Solution {
    public boolean isValid(String s) {
        Deque<Character> stack = new ArrayDeque<>();
        for(char c : s.toCharArray()){
            if ("[{(".indexOf(c) != -1){
                stack.push(c);
            }else{
                if (stack.isEmpty()) return false;
                char brak = stack.pop();
                if ((c == ']' && brak != '[') || (c == '}' && brak != '{') || (c == ')' && brak != '(')){
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}
