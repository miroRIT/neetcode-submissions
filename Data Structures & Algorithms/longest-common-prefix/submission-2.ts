class Solution {
    /**
     * @param {string[]} strs
     * @return {string}
     */
    longestCommonPrefix(strs: string[]): string {
        strs = strs.sort()
        let cmn_pre = strs[0]
        for (let i = 1; i < strs.length; i++){
            for (let j = 0; j < cmn_pre.length; j++){
                if (cmn_pre[j] != strs[i][j]){
                    cmn_pre = cmn_pre.substring(0,j)
                    break
                }
            }
        }
        return cmn_pre
    }
}
