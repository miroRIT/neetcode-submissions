class Solution {
    /**
     * @param {string[]} words
     * @return {string[]}
     */
    stringMatching(words) {
        let res = [];
        words.sort((a, b) => a.length - b.length)
        let n = words.length
        for (let i = 0; i < n - 1; i++){
            for (let j = i + 1; j < n; j++){
                if (words[j].includes(words[i])){
                    res.push(words[i])
                    break
                }
            }
        }
        return res
    }
}
