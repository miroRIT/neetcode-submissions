class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int l = 0, r = arr.length - 1;

        while (r - l >= k) {
            if (Math.abs(x - arr[l]) <= Math.abs(x - arr[r]))
                r--;
            else
                l++;
        }

        return Arrays.stream(arr, l, r + 1).boxed().toList();
    }
}