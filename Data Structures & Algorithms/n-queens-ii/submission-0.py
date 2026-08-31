class Solution:
    def totalNQueens(self, n: int) -> int:
        col = [False] * n
        posDiag = [False] * 2 * n
        negDiag = [False] * 2 * n
        count = 0

        def backtrack(r):
            nonlocal count
            if r == n:
                count += 1
                return

            for c in range(n):
                if col[c] or posDiag[r + c] or negDiag[r - c + n]:
                    continue
                col[c] = posDiag[r + c] = negDiag[r - c + n] = True
                backtrack(r + 1)
                col[c] = posDiag[r + c] = negDiag[r - c + n] = False

        backtrack(0)
        return count
