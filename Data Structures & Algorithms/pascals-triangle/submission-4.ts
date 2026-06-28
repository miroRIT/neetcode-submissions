class Solution {
    /**
     * @param {number} numRows
     * @return {number[][]}
     */
    generate(numRows: number): number[][] {
        let res: number[][] = []
        for (let i = 0; i < numRows; i++){
            let curr_row = new Array(i + 1).fill(1)
            for (let j = 1; j < i; j++){
                curr_row[j] = res[i - 1][j - 1] + res[i - 1][j]
            }
            res.push(curr_row)
        }
        return res
    }
}
