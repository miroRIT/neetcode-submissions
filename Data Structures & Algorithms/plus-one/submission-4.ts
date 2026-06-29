class Solution {
    /**
     * @param {number[]} digits
     * @return {number[]}
     */
    plusOne(digits: number[]): number[] {
        let n: number = digits.length;

        for (let i = n - 1; i > -1; i--){
            if(digits[i] < 9){
                digits[i]++
                return digits
            }
            digits[i] = 0
        }
        let res: number[] = new Array(n + 1).fill(0)
        res[0] = 1
        return res     
    }
}
