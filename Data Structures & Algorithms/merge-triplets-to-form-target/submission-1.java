class Solution {
    public boolean mergeTriplets(int[][] triplets, int[] target) {
        boolean x = false, y = false, z = false;
        for (int[] t : triplets) {
            if (t[0] > target[0] || t[1] > target[1] || t[2] > target[2])
                continue;
            x |= (t[0] == target[0]);
            y |= (t[1] == target[1]);
            z |= (t[2] == target[2]);

            if (x && y && z)
                return true;
        }

        return x && y && z;
    }
}
