class Solution {
    /**
     * @param {string} s
     * @param {string} t
     * @return {number}
     */
    appendCharacters(s, t) {
        if (!t)
            return 0
        let s_ind = 0, t_ind = 0
        while (s_ind < s.length){
            if (t[t_ind] == s[s_ind])
                t_ind += 1
             
            if (t_ind == t.length)
                return 0

            s_ind += 1
        }
        return t.length - t_ind}
}
