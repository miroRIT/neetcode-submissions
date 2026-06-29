class Solution {
    public int maxProfit(int[] prices) {
        int max_profit = 0, min_price = Integer.MAX_VALUE;
        for (int p : prices){
            if (p < min_price) min_price = p;
            else if (p - min_price > max_profit) max_profit = p - min_price;
        }
        return max_profit;
    }
}
