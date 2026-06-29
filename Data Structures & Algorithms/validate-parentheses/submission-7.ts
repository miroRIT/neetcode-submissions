class Solution {
    /**
     * @param {string} s
     * @return {boolean}
     */
    isValid(s: string): boolean {
        let stk = [];
        for (let c of s){
            if (['[', '{', '('].includes(c))
                stk.push(c)
            else{
                if (stk.length == 0) return false
                let brak = stk.pop()
                if ((c == ']' && brak != '[') || (c == '}' && brak != '{') || (c == ')' && brak != '(')){
                    return false;
                }
            }
        }
        return stk.length == 0 ? true : false
    }
}
