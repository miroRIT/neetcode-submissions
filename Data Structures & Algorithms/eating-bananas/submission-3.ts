class Solution {
    /**
     * @param {number[]} piles
     * @param {number} h
     * @return {number}
     */
    minEatingSpeed(piles: number[], h: number): number {
        let l: number = 1,
            r: number = Math.max(...piles);
        let res: number = r;

        while (l <= r) {
            let total: number = 0,
                k: number = Math.floor((l + r) / 2);

            piles.forEach((elem) => (total += Math.ceil(elem / k)));

            if (total <= h) {
                res = k;
                r = k - 1;
            } else l = k + 1;
        }
        return res;
    }
}
