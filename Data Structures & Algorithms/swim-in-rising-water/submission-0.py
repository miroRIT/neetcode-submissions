class Solution:
    def swimInWater(self, grid: List[List[int]]) -> int:
        n = len(grid)
        visited = set()
        minH = [[grid[0][0], 0, 0]]
        directions = [[0, 1], [1, 0], [0, -1], [-1, 0]]
        visited.add((0, 0))

        while minH:
            t, r, c = heapq.heappop(minH)
            if r == n - 1 and c == n - 1:
                return t
            for dr, dc in directions:
                neiR, neiC = r + dr, c + dc
                if (neiR < 0 or neiC < 0 or neiR ==n or neiC == n or (neiR, neiC) in visited):
                    continue
                visited.add((neiR, neiC))
                heapq.heappush(minH, [max(t, grid[neiR][neiC]), neiR, neiC])
        