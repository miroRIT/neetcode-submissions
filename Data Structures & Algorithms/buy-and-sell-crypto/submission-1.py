class Solution:
    def maxProfit(self, prices: List[int]) -> int:
        min_price = float('inf')
        max_profit = 0

        for price in prices:
            # Update minimum price so far
            if price < min_price:
                min_price = price
            else:
                # Calculate profit if selling today
                max_profit = max(max_profit, price - min_price)

        return max_profit