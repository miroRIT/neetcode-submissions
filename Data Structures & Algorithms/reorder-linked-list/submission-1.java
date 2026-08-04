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
    public void reorderList(ListNode head) {
        ListNode slow = head, fast = head.next;
        while (fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode l2 = slow.next;
        ListNode prev = slow.next = null;
        while (l2 != null){
            ListNode tmp = l2.next;
            l2.next = prev;
            prev = l2;
            l2 = tmp;
        }
        ListNode l1 = head;
        l2 = prev;
        while (l2 != null){
            ListNode tmp2 = l2.next, tmp1 = l1.next;
            l1.next = l2;
            l2.next = tmp1;
            l1 = tmp1;
            l2 = tmp2;
        }
    }
}
