class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()){
            return false;
        }
        java.util.HashMap<Character, Integer> dict = new java.util.HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char sc = s.charAt(i);
            char tc = t.charAt(i);

            dict.put(sc, dict.getOrDefault(sc, 0) + 1);
            dict.put(tc, dict.getOrDefault(tc, 0) - 1);
        }
        for (char elem : dict.keySet()){
            if (dict.get(elem) != 0){
                return false;
            }
        }
        return true;
    }
}
