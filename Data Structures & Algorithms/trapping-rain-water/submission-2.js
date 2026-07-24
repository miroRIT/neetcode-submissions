class Solution {
    /**
     * @param {number[]} height
     * @return {number}
     */
    trap(height) {
        let n = height.length;
        let area = 0;
        let l_max = new Array(n).fill(0);
        let r_max = new Array(n).fill(0);
        l_max[0] = height[0];
        r_max[n - 1] = height[n - 1];
        for (let i = 1; i < n; i++) l_max[i] = Math.max(l_max[i - 1], height[i]);
        for (let i = n - 2; i > -1; i--) r_max[i] = Math.max(r_max[i + 1], height[i]);
        for (let i = 0; i < n; i++) area += Math.min(l_max[i], r_max[i]) - height[i];
        return area;
    }
}
