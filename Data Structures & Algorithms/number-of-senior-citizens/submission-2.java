class Solution {
    public int countSeniors(String[] details) {
        int res = 0;
        for (String elem : details){
            if (Integer.parseInt(elem.substring(11, 13)) > 60){
                res++;
            }
        }
        return res;
    }
}