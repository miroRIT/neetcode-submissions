class Solution:
    def generate(self, numRows: int) -> List[List[int]]:
        res = []
        for i in range(numRows):
            curr_row = [1] * (i + 1)
            for j in range(1, i):
                curr_row [j] = res[i - 1][j - 1] + res[i - 1][j]
            res.append(curr_row)
        return res
        