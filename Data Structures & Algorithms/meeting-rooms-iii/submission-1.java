class Solution {
    public int mostBooked(int n, int[][] meetings) {
        Arrays.sort(meetings, (a, b) -> Long.compare(a[0], b[0]));
        PriorityQueue<Integer> avail = new PriorityQueue<>();
        PriorityQueue<long[]> used = new PriorityQueue<>(
            (a, b) -> a[0] == b[0] ? Long.compare(a[1], b[1]) : Long.compare(a[0], b[0]));
        for (int i = 0; i < n; i++) avail.offer(i);

        int[] count = new int[n];

        for (int[] meeting : meetings) {
            long s = meeting[0];
            long e = meeting[1];
            while (!used.isEmpty() && used.peek()[0] <= s) {
                int room = (int) used.poll()[1];
                avail.offer(room);
            }
            if (avail.isEmpty()) {
                long[] cur = used.poll();
                int room = (int) cur[1];
                e = cur[0] + (e - s);
                avail.offer(room);
            }
            int room = avail.poll();
            used.offer(new long[] {e, room});
            count[room]++;
        }

        int maxRoom = 0;
        for (int i = 1; i < n; i++)
            if (count[i] > count[maxRoom])
                maxRoom = i;

        return maxRoom;
    }
}