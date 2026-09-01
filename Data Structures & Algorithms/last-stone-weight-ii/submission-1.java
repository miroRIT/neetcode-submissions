class Solution {
    public int lastStoneWeightII(int[] stones) {
        int sum = 0;
        for (int stone : stones) sum += stone;

        int tar = sum / 2;

        Set<Integer> dp = new HashSet<>();
        dp.add(0);

        for (int stone : stones) {
            Set<Integer> newDp = new HashSet<>(dp);
            for (int val : dp) {
                if (val + stone == tar)
                    return sum - 2 * tar;
                if (val + stone < tar)
                    newDp.add(val + stone);
            }
            dp = newDp;
        }

        int max = 0;
        for (int val : dp) max = Math.max(max, val);

        return sum - 2 * max;
    }
}