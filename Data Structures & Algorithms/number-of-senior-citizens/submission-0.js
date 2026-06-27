class Solution {
    /**
     * @param {string[]} details
     * @return {number}
     */
    countSeniors(details) {
        let res = 0;
        for (let elem of details){
            if (parseInt(elem.substring(11, 13)) > 60){
                res++
            }
        }
        return res;
    }
}
