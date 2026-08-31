class Solution {
    public String addBinary(String a, String b) {
        StringBuilder res = new StringBuilder();

        int i = a.length() - 1, j = b.length() - 1, car = 0;

        while (i >= 0 || j >= 0 || car > 0) {
            int digA = i >= 0 ? a.charAt(i) - '0' : 0;
            int digB = j >= 0 ? b.charAt(j) - '0' : 0;

            int tot = digA + digB + car;
            res.append(tot % 2);
            car = tot / 2;
            i--;
            j--;
        }

        return res.reverse().toString();
    }
}