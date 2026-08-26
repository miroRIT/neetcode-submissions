class ListNode {
    int key, val, freq;
    ListNode next, prev;

    public ListNode(int key, int val) {
        this.key = key;
        this.val = val;
        this.freq = 1;
        this.next = null;
        this.prev = null;
    }
}

class DoublyLinkedList {
    private ListNode left, right;
    private int size;

    public DoublyLinkedList() {
        this.left = new ListNode(0, 0);
        this.right = new ListNode(0, 0);
        this.left.next = this.right;
        this.right.prev = this.left;
        this.size = 0;
    }

    public int length() {
        return size;
    }

    public void pushRight(ListNode node) {
        ListNode prev = this.right.prev;
        prev.next = node;
        node.prev = prev;
        node.next = this.right;
        this.right.prev = node;
        size++;
    }

    public void pop(ListNode node) {
        ListNode prev = node.prev, next = node.next;
        prev.next = next;
        next.prev = prev;
        node.prev = node.next = null;
        size--;
    }

    public ListNode popLeft() {
        ListNode node = this.left.next;
        pop(node);
        return node;
    }
}

class LFUCache {
    private int cap, lfuCnt;
    private Map<Integer, ListNode> nodeMap;
    private Map<Integer, DoublyLinkedList> listMap;

    public LFUCache(int capacity) {
        this.cap = capacity;
        this.lfuCnt = 0;
        this.nodeMap = new HashMap<>();
        this.listMap = new HashMap<>();
    }

    public void counter(ListNode node) {
        int cnt = node.freq;
        listMap.get(cnt).pop(node);

        if (cnt == lfuCnt && listMap.get(cnt).length() == 0)
            lfuCnt++;

        node.freq++;
        listMap.putIfAbsent(node.freq, new DoublyLinkedList());
        listMap.get(node.freq).pushRight(node);
    }

    public int get(int key) {
        if (!nodeMap.containsKey(key))
            return -1;

        ListNode node = nodeMap.get(key);
        counter(node);
        return node.val;
    }

    public void put(int key, int value) {
        if (cap == 0)
            return;

        if (nodeMap.containsKey(key)) {
            ListNode node = nodeMap.get(key);
            node.val = value;
            counter(node);
            return;
        }

        if (nodeMap.size() == cap) {
            ListNode toRemove = listMap.get(lfuCnt).popLeft();
            nodeMap.remove(toRemove.key);
        }

        ListNode node = new ListNode(key, value);
        nodeMap.put(key, node);
        listMap.putIfAbsent(1, new DoublyLinkedList());
        listMap.get(1).pushRight(node);
        lfuCnt = 1;
    }
}

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */