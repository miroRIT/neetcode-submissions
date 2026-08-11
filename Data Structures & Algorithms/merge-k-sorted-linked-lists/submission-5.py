# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next

class Solution:    
    def mergeKLists(self, lists: List[Optional[ListNode]]) -> Optional[ListNode]:
        if not len(lists): return None

        return self.divide(lists, 0, len(lists) - 1)
    
    def divide(self, lists: List[Optional[ListNode]], l: int, r: int) -> Optional[ListNode]:
        if l > r: return None
        if l == r: return lists[l]

        mid = (l + r) // 2

        left = self.divide(lists, l, mid)
        right = self.divide(lists, mid + 1, r)

        return self.conquer(left, right)

    def conquer(self, l: Optional[ListNode], r: Optional[ListNode]) -> Optional[ListNode]:
        dummy = ListNode(0)
        curr = dummy

        while l and r:
            if l.val < r.val:
                curr.next = l
                l = l.next
            else:
                curr.next = r
                r = r.next
            curr = curr.next
        
        if l: curr.next = l
        if r: curr.next = r

        return dummy.next