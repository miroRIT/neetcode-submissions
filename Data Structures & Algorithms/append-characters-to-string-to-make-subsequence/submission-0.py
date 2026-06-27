class Solution:
    def appendCharacters(self, s: str, t: str) -> int:
        if not t:
            return 0
        s_ind = t_ind = 0
        while s_ind < len(s):
            if t[t_ind] == s[s_ind]:
                t_ind += 1
             
            if t_ind == len(t):
                return 0

            s_ind += 1
        
        return len(t) - t_ind
            