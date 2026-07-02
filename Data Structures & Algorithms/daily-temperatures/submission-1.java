class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<int[]> stk = new Stack<>();
        int[] res = new int[temperatures.length];
        for (int i = 0; i < temperatures.length; i++){
            while (!stk.isEmpty() && temperatures[i] > stk.peek()[0]){
                int[] pair = stk.pop();
                res[pair[1]] = i - pair[1];
            }
            stk.push(new int[] {temperatures[i], i});
        }
        return res;
    }
}
