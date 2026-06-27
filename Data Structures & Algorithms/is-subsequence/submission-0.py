class Solution:
    def isSubsequence(self, s: str, t: str) -> bool:
        t_ind = s_ind = 0
        n = len(t)
        for i in range(len(s)):
            for j in range(t_ind, n):
                if s[i] == t[j]:
                    s_ind += 1
                    t_ind += 1
                    break
                else:
                    t_ind += 1
        return True if s_ind == len(s) else False