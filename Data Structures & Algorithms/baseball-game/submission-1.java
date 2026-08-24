class Solution {
    public int calPoints(String[] operations) {
        List<Integer> res = new ArrayList<>();
        int sum = 0;
        for (String op : operations) {
            if (op.equals("+"))
                res.add(res.get(res.size() - 1) + res.get(res.size() - 2));
            else if (op.equals("D"))
                res.add(res.get(res.size() - 1) * 2);
            else if (op.equals("C"))
                res.remove(res.size() - 1);
            else
                res.add(Integer.valueOf(op));
        }

        for (Integer i : res) sum += i;

        return sum;
    }
}