class UnionFind {
    private final Map<String, String> par;
    private final Map<String, Double> weight;

    public UnionFind() {
        par = new HashMap<>();
        weight = new HashMap<>();
    }

    public void add(String x) {
        if (!par.containsKey(x)) {
            par.put(x, x);
            weight.put(x, 1.0);
        }
    }

    public String find(String x) {
        if (!x.equals(par.get(x))) {
            String og_par = par.get(x);
            par.put(x, find(og_par));
            weight.put(x, weight.get(x) * weight.get(og_par));
        }
        return par.get(x);
    }

    public void union(String x, String y, double val) {
        add(x);
        add(y);
        String rootx = find(x);
        String rooty = find(y);

        if (!rootx.equals(rooty)) {
            par.put(rootx, rooty);
            weight.put(rootx, val * weight.get(y) / weight.get(x));
        }
    }

    public double getRatio(String x, String y) {
        if (!par.containsKey(x) || !par.containsKey(y) || !find(x).equals(find(y))) return -1.0;
        return weight.get(x) / weight.get(y);
    }
}

class Solution {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        UnionFind uf = new UnionFind();

        for (int i = 0; i < equations.size(); i++) {
            List<String> equation = equations.get(i);
            String a = equation.get(0);
            String b = equation.get(1);
            uf.union(a, b, values[i]);
        }

        double[] result = new double[queries.size()];

        for (int i = 0; i < queries.size(); i++) {
            List<String> query = queries.get(i);
            String a = query.get(0);
            String b = query.get(1);
            result[i] = uf.getRatio(a, b);
        }

        return result;
    }
}