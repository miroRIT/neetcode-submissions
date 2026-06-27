class Solution {
    public boolean isSubsequence(String s, String t) {
        if (s.isEmpty()){
            return true;
        }
        int s_ind = 0, t_ind = 0;
        while (t_ind < t.length()){
            if (s.charAt(s_ind) == t.charAt(t_ind)){
                s_ind++;
            }
            
            if (s_ind == s.length()){
                return true;
            }

            t_ind++;
        }
        return false;
    }
}