class Solution {
    public String longestCommonPrefix(String[] strs) {
        Arrays.sort(strs);
        String cmn_pre = strs[0];
        for (int i = 1; i < strs.length; i++){
            for (int j = 0; j < cmn_pre.length(); j++){
                if (cmn_pre.charAt(j) != strs[i].charAt(j)){
                    cmn_pre = cmn_pre.substring(0,j);
                    break;
                }
            }
        }
        return cmn_pre;
    }
}