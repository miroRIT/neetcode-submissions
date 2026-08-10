class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] course = new int[numCourses];
        List<List<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < numCourses; i++){
            adj.add(new ArrayList<>());
        }

        for (int[] pre : prerequisites){
            course[pre[1]]++;
            adj.get(pre[0]).add(pre[1]);
        }

        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < numCourses; i++){
            if (course[i] == 0) q.add(i);
        }

        int finish = 0;
        int[] output = new int[numCourses];
        while (!q.isEmpty()){
            int node = q.poll();
            output[numCourses - finish - 1] = node;
            finish++;
            for (int nei : adj.get(node)){
                course[nei]--;
                if (course[nei] == 0) q.add(nei);
            }
        }

        if (finish != numCourses) return new int[0];
        return output;
    }
}
