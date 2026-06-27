class Solution {
    /**
     * @param {string[]} details
     * @return {number}
     */
    countSeniors(details: string[]): number {
        let res = 0;
        details.forEach((item, index) => {
            if (parseInt(item.substring(11, 13)) > 60){
                res++
            }
        });
        return res;
    }
}
