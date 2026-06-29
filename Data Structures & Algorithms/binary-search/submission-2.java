class Solution {
    public int search(int[] nums, int target) {
        return binarysearch(nums, target, 0, nums.length - 1);
    }
    public int binarysearch(int[] nums, int target, int left, int right) {
        if (left > right) return -1;
        int mid = left + (right - left) / 2;
        if(nums[mid] == target) return mid;
        else if (target > nums[mid]) return binarysearch(nums, target , mid + 1, right);
        else return binarysearch(nums, target, 0, mid - 1);
    }
}
