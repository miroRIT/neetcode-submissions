class Solution {
    public int singleNumber(int[] nums) {
        int res = 0;
        for (int elem : nums) res ^= elem;
        return res;
    }
}
