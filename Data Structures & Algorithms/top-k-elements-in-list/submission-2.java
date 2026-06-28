class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : nums){
            map.put(i ,map.getOrDefault(i, 0) + 1);
        }
        // 2. Create buckets where index = frequency
        // We use an array of ArrayLists
        List<Integer>[] freq = new ArrayList[nums.length + 1];
        for (int i = 0; i < freq.length; i++) {
            freq[i] = new ArrayList<>();
        }

        // 3. Populate buckets
        for (int key : map.keySet()) {
            int count = map.get(key);
            freq[count].add(key);
        }

        // 4. Collect top K elements
        int[] res = new int[k];
        int index = 0;
        for (int i = freq.length - 1; i >= 0 && index < k; i--) {
            for (int val : freq[i]) {
                res[index++] = val;
                if (index == k) return res;
            }
        }
        return res;
    }
}
