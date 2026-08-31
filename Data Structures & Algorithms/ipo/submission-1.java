class Solution {
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        int n = profits.length;
        Integer[] indices = new Integer[n];
        for (int i = 0; i < n; i++) indices[i] = i;

        Arrays.sort(indices, (a, b) -> Integer.compare(capital[a], capital[b]));

        PriorityQueue<Integer> maxProfit = new PriorityQueue<>(Collections.reverseOrder());
        int id = 0;

        for (int i = 0; i < k; i++) {
            while (id < n && capital[indices[id]] <= w) maxProfit.add(profits[indices[id++]]);

            if (maxProfit.isEmpty())
                break;

            w += maxProfit.poll();
        }

        return w;
    }
}