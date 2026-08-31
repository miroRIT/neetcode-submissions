class SegmentTree {
    int n;
    int[] tree, lazy;

    SegmentTree(int N) {
        this.n = N;
        tree = new int[4 * N];
        lazy = new int[4 * N];
        Arrays.fill(tree, Integer.MAX_VALUE);
        Arrays.fill(lazy, Integer.MAX_VALUE);
    }

    void propagate(int treeidx, int lo, int hi) {
        if (lazy[treeidx] != Integer.MAX_VALUE) {
            tree[treeidx] = Math.min(tree[treeidx], lazy[treeidx]);
            if (lo != hi) {
                lazy[2 * treeidx + 1] = Math.min(lazy[2 * treeidx + 1], lazy[treeidx]);
                lazy[2 * treeidx + 2] = Math.min(lazy[2 * treeidx + 2], lazy[treeidx]);
            }
            lazy[treeidx] = Integer.MAX_VALUE;
        }
    }

    void update(int treeidx, int lo, int hi, int l, int r, int val) {
        propagate(treeidx, lo, hi);
        if (lo > r || hi < l)
            return;
        if (lo >= l && hi <= r) {
            lazy[treeidx] = Math.min(lazy[treeidx], val);
            propagate(treeidx, lo, hi);
            return;
        }
        int mid = (lo + hi) / 2;
        update(2 * treeidx + 1, lo, mid, l, r, val);
        update(2 * treeidx + 2, mid + 1, hi, l, r, val);
        tree[treeidx] = Math.min(tree[2 * treeidx + 1], tree[2 * treeidx + 2]);
    }

    int query(int treeidx, int lo, int hi, int idx) {
        propagate(treeidx, lo, hi);
        if (lo == hi)
            return tree[treeidx];
        int m = (lo + hi) / 2;
        if (idx <= m)
            return query(2 * treeidx + 1, lo, m, idx);
        else
            return query(2 * treeidx + 2, m + 1, hi, idx);
    }

    void update(int l, int r, int val) {
        update(0, 0, n - 1, l, r, val);
    }

    int query(int idx) {
        return query(0, 0, n - 1, idx);
    }
}

class Solution {
    public int[] minInterval(int[][] intervals, int[] queries) {
        List<Integer> points = new ArrayList<>();
        for (int[] interval : intervals) {
            points.add(interval[0]);
            points.add(interval[1]);
        }
        for (int q : queries) points.add(q);
        points = new ArrayList<>(new HashSet<>(points));
        Collections.sort(points);

        Map<Integer, Integer> comp = new HashMap<>();
        for (int i = 0; i < points.size(); i++)
            comp.put(points.get(i), i);
        
        SegmentTree seg = new SegmentTree(points.size());

        for (int[] i : intervals) {
            int s = comp.get(i[0]);
            int e = comp.get(i[1]);
            int len = i[1] - i[0] + 1;
            seg.update(s, e, len);
        }

        int[] ans = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int id = comp.get(queries[i]);
            int res = seg.query(id);
            ans[i] = (res == Integer.MAX_VALUE) ? -1 : res;
        }

        return ans;
    }
}
