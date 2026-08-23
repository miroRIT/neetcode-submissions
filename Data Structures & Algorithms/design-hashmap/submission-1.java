class ListNode {
    int key, val;
    ListNode next;

    public ListNode(int key, int value, ListNode next) {
        this.key = key;
        this.val = value;
        this.next = next;
    }

    public ListNode() {
        this(-1, -1, null);
    }
}

class MyHashMap {
    private ListNode[] map;

    public MyHashMap() {
        map = new ListNode[1000];
        for (int i = 0; i < 1000; i++) map[i] = new ListNode();
    }

    public void put(int key, int value) {
        ListNode cur = map[getHash(key)];
        while (cur.next != null) {
            if (cur.next.key == key) {
                cur.next.val = value;
                return;
            }
            cur = cur.next;
        }
        cur.next = new ListNode(key, value, null);
    }

    public int get(int key) {
        ListNode cur = map[getHash(key)];
        while (cur != null) {
            if (cur.key == key)
                return cur.val;
            cur = cur.next;
        }
        return -1;
    }

    public void remove(int key) {
        ListNode cur = map[getHash(key)];
        while (cur.next != null) {
            if (cur.next.key == key) {
                cur.next = cur.next.next;
                return;
            }
            cur = cur.next;
        }
    }

    private int getHash(int key) {
        return key % map.length;
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */