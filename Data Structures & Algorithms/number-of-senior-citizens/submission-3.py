class Solution:
    def countSeniors(self, details: List[str]) -> int:
        res = 0
        for elem in details:
            if int(elem[11:13]) > 60:
                res += 1
        return res