class Solution:
    def isSubsequence(self, s: str, t: str) -> bool:
        if not s:
            return True
        t_ind = s_ind = 0
        while t_ind < len(t):
            if s[s_ind] == t[t_ind]:
                s_ind += 1
            
            if s_ind == len(s):
                return True
            
            t_ind += 1
        return False
