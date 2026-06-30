class Solution {
    /**
     * @param {number[]} heights
     * @return {number}
     */
    maxArea(heights) {
        let n = heights.length;
        let maxAr = 0, l = 0, r = n - 1;

        while (l < r){
            let min = Math.min(heights[r], heights[l]);
            maxAr = Math.max(maxAr, (r - l) * min);
            if (min === heights[r]) r--;
            else l++;
        }
        return maxAr;
    }
}
