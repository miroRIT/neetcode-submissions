/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0)
            return null;
        
        return divide(lists, 0, lists.length - 1);
    }

    public ListNode divide(ListNode[] lists, int left, int right){
        if (left > right) return null;
        if (left == right) return lists[left];
        int mid = left + (right - left) / 2;
        ListNode l = divide(lists, left, mid);
        ListNode r = divide(lists, mid + 1, right);

        return conquer(l, r);
    }

    public ListNode conquer(ListNode l, ListNode r){
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;

        while (l != null && r != null){
            if (l.val < r.val){
                curr.next = l;
                l = l.next;
            }else{
                curr.next = r;
                r = r.next;
            }
            curr = curr.next;
        }

        if (l != null) curr.next = l;
        if (r != null) curr.next = r;

        return dummy.next;
    }
}
