class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int n1 = s1.length();
        int n2 = s2.length();
        if (n1 > n2) return false;

        int[] s1Count = new int[26];
        int[] s2Count = new int[26];
        for (int i = 0; i < n1; i++){
            s1Count[s1.charAt(i) - 'a']++;
            s2Count[s2.charAt(i) - 'a']++;
        }

        int match = 0;
        for (int i = 0; i < 26; i++) if (s1Count[i] == s2Count[i]) match++;

        int l = 0;
        for (int r = n1; r < n2; r++){
            if (match == 26) return true;

            int ind = s2.charAt(r) - 'a';
            s2Count[ind]++;
            if (s2Count[ind] == s1Count[ind]) match++;
            else if (s2Count[ind] == s1Count[ind] + 1) match--;

            ind = s2.charAt(l) - 'a';
            s2Count[ind]--;
            if (s2Count[ind] == s1Count[ind]) match++;
            else if (s2Count[ind] == s1Count[ind] - 1) match--;
             
            l++;
        }

        return match == 26;
    }
}
