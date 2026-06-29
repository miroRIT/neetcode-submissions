class Solution:
    def countBits(self, n: int) -> List[int]:
        count = []
        for i in range(n + 1):
            n = i
            curr_count = 0
            while n:
                n = n & (n - 1)
                curr_count += 1
            count.append(curr_count)
        return count
        