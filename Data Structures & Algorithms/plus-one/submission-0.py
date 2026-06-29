class Solution:
    def plusOne(self, digits: List[int]) -> List[int]:
        res = "".join(str(x) for x in digits)
        res = int(res) + 1
        return [int(x) for x in str(res)]