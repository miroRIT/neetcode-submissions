class Solution {
    /**
     * @param {number[]} arr
     * @return {number[]}
     */
    replaceElements(arr) {
        let n = arr.length
        let max = -1
        for (let i = n - 1; i >= 0; i--){
            let val = arr[i]
            arr[i] = max
            max = Math.max(max, val)
        }
        return arr
    }
}
