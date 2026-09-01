class Solution {
    public String predictPartyVictory(String senate) {
        int r = 0, d = 0;
        char[] arr = senate.toCharArray();
        for (char c : arr) {
            if (c == 'R') {
                r++;
            } else {
                d++;
            }
        }

        int dv = 0, rv = 0;

        while (r > 0 && d > 0) {
            for (int i = 0; i < arr.length; i++) {
                char c = arr[i];
                if (c == 'R') {
                    if (dv > 0) {
                        dv--;
                        r--;
                        arr[i] = '.';
                    } else
                        rv++;
                } else if (c == 'D') {
                    if (rv > 0) {
                        rv--;
                        d--;
                        arr[i] = '.';
                    } else
                        dv++;
                }
            }
        }

        return r > 0 ? "Radiant" : "Dire";
    }
}