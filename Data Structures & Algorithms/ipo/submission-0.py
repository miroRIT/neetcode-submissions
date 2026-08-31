class Solution:
    def findMaximizedCapital(self, k: int, w: int, profits: List[int], capital: List[int]) -> int:
        n = len(profits)

        indices = list(range(n))
        indices.sort(key=lambda i: capital[i])

        maxProfit, id = [], 0

        for _ in range(k):
            while id < n and capital[indices[id]] <= w:
                heapq.heappush(maxProfit, -profits[indices[id]])
                id += 1

            if not maxProfit:
                break

            w += -heapq.heappop(maxProfit)

        return w
