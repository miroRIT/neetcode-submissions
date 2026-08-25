class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int l = Integer.MIN_VALUE;
        int r = 0;

        for (int w : weights) {
            l = Math.max(l, w);
            r += w;
        }
        int res = r;

        while (l <= r) {
            int cap = l + (r - l) / 2;
            if (canShip(weights, cap, days)) {
                res = Math.min(res, cap);
                r = cap - 1;
            } else
                l = cap + 1;
        }

        return res;
    }

    private boolean canShip(int[] weigths, int cap, int days) {
        int ships = 1, curCap = cap;

        for (int w : weigths) {
            if (curCap - w < 0) {
                ships++;
                if (ships > days)
                    return false;
                curCap = cap;
            }
            curCap -= w;
        }

        return true;
    }
}