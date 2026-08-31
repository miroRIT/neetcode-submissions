class Solution {
    public String reorganizeString(String s) {
        int[] freq = new int[26];

        for (char c : s.toCharArray()) freq[c - 'a']++;

        int maxId = 0;
        for (int i = 1; i < 26; i++)
            if (freq[i] > freq[maxId])
                maxId = i;

        int maxFreq = freq[maxId];

        if (maxFreq > (s.length() + 1) / 2)
            return "";

        char[] res = new char[s.length()];
        int id = 0;
        char maxChar = (char) (maxId + 'a');

        while (freq[maxId] > 0){
            res[id] = maxChar;
            id += 2;
            freq[maxId]--;
        }

        for (int i = 0; i < 26; i++){
            while (freq[i] > 0) {
                if (id >= s.length())
                    id = 1;
                res[id] = (char) (i + 'a');
                id += 2;
                freq[i]--;
            }
        }

        return new String(res);
    }
}