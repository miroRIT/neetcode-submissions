/*
Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public Node cloneGraph(Node node) {
        if (node == null) return node;

        Map<Node, Node> oN = new HashMap<>();
        oN.put(node, new Node(node.val));
        Queue<Node> q = new LinkedList<>();
        q.add(node);

        while (!q.isEmpty()){
            Node cur = q.poll();
            for (Node nei : cur.neighbors){
                if (!oN.containsKey(nei)){
                    oN.put(nei, new Node(nei.val));
                    q.add(nei);
                }
                oN.get(cur).neighbors.add(oN.get(nei));
            }
        }

        return oN.get(node);
    }
}