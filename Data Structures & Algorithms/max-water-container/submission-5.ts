class Solution {
    /**
     * @param {number[]} heights
     * @return {number}
     */
    maxArea(heights: number[]): number {
        let n: number = heights.length;
        let maxAr: number = 0,
            l: number = 0,
            r: number = n - 1;

        while (l < r) {
            let min: number = Math.min(heights[r], heights[l]);
            maxAr = Math.max(maxAr, (r - l) * min);
            if (min === heights[r]) r--;
            else l++;
        }
        return maxAr;
    }
}
