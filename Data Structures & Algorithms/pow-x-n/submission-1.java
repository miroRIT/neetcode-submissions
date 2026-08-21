class Solution {
    public double myPow(double x, int n) {
        if (x == 0) return x;
        if (n == 0) return 1;

        long pow = Math.abs((long) n);
        double res = 1;

        while (pow > 0){
            if ((pow & 1) == 1) res *= x;
            x *= x;
            pow >>= 1;
        }
        return n >= 0 ? res : 1 / res;
    }
}
