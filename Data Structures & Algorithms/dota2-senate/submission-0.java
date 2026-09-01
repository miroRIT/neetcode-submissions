class Solution {
    public String predictPartyVictory(String senate) {
        StringBuilder sb = new StringBuilder(senate);
        int cnt = 0, i = 0;

        while (i < sb.length()) {
            char c = sb.charAt(i);
            if (c == 'R') {
                if (cnt++ < 0)
                    sb.append('D');
            } else {
                if (cnt-- > 0)
                    sb.append('R');
            }
            i++;
        }

        return cnt > 0 ? "Radiant" : "Dire";
    }
}