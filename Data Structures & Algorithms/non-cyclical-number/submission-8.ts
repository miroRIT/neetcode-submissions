class Solution {
    /**
     * @param {number} n
     * @return {boolean}
     */
    isHappy(n: number): boolean {
        let seen = new Set();
        
        while (n != 1 && !seen.has(n)){
            seen.add(n);
            let res = 0;
            while (n > 0){
                let digit = n % 10;
                res += digit ** 2;
                n = Math.floor(n / 10);
            }
            n = res;
        }
        return n === 1;
    }
}
