class Solution {
    public int lastStoneWeight(int[] stones) {
        ArrayList<Integer> list = new ArrayList<>();
        for (int s : stones) list.add(s);
        
        return clashStones(list);
    }
    public int clashStones(ArrayList<Integer> stones){
        int n = stones.size();
        if (n == 0) return 0;
        if (n == 1) return stones.get(0);
        stones.sort(Collections.reverseOrder());
        int i1 = stones.remove(1);
        int i0 = stones.remove(0);
        if (i0 != i1) stones.add(i0 - i1);
        return clashStones(stones);
    }
}
