/**
 * // This is MountainArray's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface MountainArray {
 *     public int get(int index) {}
 *     public int length() {}
 * }
 */

class Solution {
    private Map<Integer, Integer> cache = new HashMap<>();

    public int findInMountainArray(int target, MountainArray mountainArr) {
        int len = mountainArr.length();
        int l = 1, r = len - 2;
        int m = 0;

        while (l <= r) {
            m = (l + r) >> 1;
            int left = get(mountainArr, m - 1), mid = get(mountainArr, m),
                right = get(mountainArr, m + 1);

            if (left < mid && mid < right)
                l = m + 1;
            else if (left > mid && mid > right)
                r = m - 1;
            else
                break;
        }

        int res = binary(mountainArr, target, 0, m, true);

        return (res != -1) ? res : binary(mountainArr, target, m, len - 1, false);
    }

    private int get(MountainArray mountainArr, int i) {
        if (!cache.containsKey(i))
            cache.put(i, mountainArr.get(i));
        return cache.get(i);
    }

    private int binary(MountainArray mountainArr, int target, int l, int r, boolean bool) {
        while (l <= r) {
            int m = (l + r) >> 1;
            int val = get(mountainArr, m);

            if (val == target)
                return m;
            if (bool == (val < target))
                l = m + 1;
            else
                r = m - 1;
        }

        return -1;
    }
}