class Solution {
    /**
     * @param {number[]} prices
     * @return {number}
     */
    maxProfit(prices: number[]): number {
        let max_profit = 0, min_price = Number.MAX_VALUE;
        for (let p of prices){
            if (p < min_price) min_price = p;
            else if (p - min_price > max_profit) max_profit = p - min_price;
        }
        return max_profit;
    }
}
