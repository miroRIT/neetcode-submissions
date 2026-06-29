class Solution {
    public int[] plusOne(int[] digits) {
        StringBuilder res = new StringBuilder();
        for (int d : digits) res.append(d);
        long val = Long.parseLong(res.toString()) + 1;
        String s = Long.toString(val);
        int[] result = new int[s.length()];
        for (int i = 0; i < s.length(); i++) result[i] = s.charAt(i) - '0';
        return result;
    }
}
