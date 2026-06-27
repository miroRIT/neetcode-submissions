class Solution {
    /**
     * @param {string} s
     * @param {string} t
     * @return {boolean}
     */
    isSubsequence(s, t) {
        if (!s) return true
        
        let t_ind = 0, s_ind = 0

        while (t_ind < t.length){
            if (s[s_ind] == t[t_ind]){
                s_ind++
            }

            if(s_ind == s.length) return true

            t_ind++
        }

        return false


    }
}
