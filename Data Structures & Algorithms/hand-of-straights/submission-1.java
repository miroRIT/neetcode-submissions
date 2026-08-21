class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        int n = hand.length;

        if (n % groupSize != 0)
            return false;

        Map<Integer, Integer> count = new HashMap<>();

        for (int card : hand) count.put(card, count.getOrDefault(card, 0) + 1);

        for (int card : hand) {
            int start = card;
            while (count.getOrDefault(start - 1, 0) > 0) start--;
            while (start <= card) {
                while (count.getOrDefault(start, 0) > 0) {
                    for (int i = start; i < start + groupSize; i++) {
                        if (count.getOrDefault(i, 0) == 0)
                            return false;
                        count.put(i, count.get(i) - 1);
                    }
                }
                start++;
            }
        }
        return true;
    }
}
