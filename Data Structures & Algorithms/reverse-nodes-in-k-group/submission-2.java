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
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode(0, head);
        ListNode gP = dummy;

        while (true) {
            ListNode kth = getKth(gP, k);
            if (kth == null)
                break;
            ListNode gN = kth.next;

            ListNode cur = gP.next, prev = kth.next;
            while (cur != gN){
                ListNode tmp = cur.next;
                cur.next = prev;
                prev = cur;
                cur = tmp;
            }

            ListNode tmp = gP.next;
            gP.next = kth;
            gP = tmp;
        }
        return dummy.next;
    }

    private ListNode getKth(ListNode cur, int k){
        while (k > 0 && cur != null){
            cur = cur.next;
            k--;
        }
        return cur;
    }
}
