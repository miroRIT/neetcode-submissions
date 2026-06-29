class Solution {
    /**
     * @param {number[]} digits
     * @return {number[]}
     */
    plusOne(digits) {
        let n = digits.length;

        for (let i = n - 1; i > -1; i--){
            if(digits[i] < 9){
                digits[i]++
                return digits
            }
            digits[i] = 0
        }
        digits.unshift(1)
        return digits  
    }
}
