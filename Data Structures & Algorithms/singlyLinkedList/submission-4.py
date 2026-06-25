class ListNode:
    def __init__(self, val, next_node = None):
        self.next_node = next_node
        self.val = val

class LinkedList:
    
    def __init__(self):
        self.head = ListNode(-1)
        self.tail = self.head
    
    def get(self, index: int) -> int:
        curr = self.head.next_node
        i = 0
        while curr:
            if index == i:
                return curr.val
            i += 1
            curr = curr.next_node
        return -1 

    def insertHead(self, val: int) -> None:
        new_node = ListNode(val, self.head.next_node)
        self.head.next_node = new_node
        if not new_node.next_node:
            self.tail = new_node

    def insertTail(self, val: int) -> None:
        self.tail.next_node = ListNode(val)
        self.tail = self.tail.next_node
        

    def remove(self, index: int) -> bool:
        curr = self.head
        i = 0
        while curr and i < index:
            curr = curr.next_node
            i += 1
        if curr and curr.next_node:
            if curr.next_node == self.tail:
                self.tail = curr
            curr.next_node = curr.next_node.next_node
            return True
        return False

    def getValues(self) -> List[int]:
        val = []
        curr = self.head.next_node
        while curr:
            val.append(curr.val)
            curr = curr.next_node
        return val
        
