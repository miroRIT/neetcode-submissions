class Solution:
    def longestCommonPrefix(self, strs: List[str]) -> str:
        strs.sort()
        cmn_pre = strs[0]

        for i in range(1, len(strs)):
            for j in range(len(cmn_pre)):
                if cmn_pre[j] != strs[i][j]:
                    cmn_pre = cmn_pre[:j]
                    break
        return cmn_pre