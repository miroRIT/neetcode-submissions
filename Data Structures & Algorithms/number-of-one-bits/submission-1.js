class Solution {
    /**
     * @param {number} n - a positive integer
     * @return {number}
     */
    hammingWeight(n) {
        let weight = 0
        while (n){
            n = n & (n - 1)
            weight++
        }
        return weight
    }
}
