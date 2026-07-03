class Solution {
    /**
     * @param {number[]} piles
     * @param {number} h
     * @return {number}
     */
    minEatingSpeed(piles, h) {
        let l = 1,
            r = Math.max(...piles);
        let res = r;

        while (l <= r) {
            let total = 0,
                k = Math.floor((l + r) / 2);

            piles.forEach((elem) => (total += Math.ceil(elem / k)));

            if (total <= h) {
                res = k;
                r = k - 1;
            } else l = k + 1;
        }
        return res;
    }
}
