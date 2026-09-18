class UnionFind:
    def __init__(self):
        self.par = {}
        self.weight = {}

    def add(self, x):
        if x not in self.par:
            self.par[x] = x
            self.weight[x] = 1.0

    def find(self, x):
        if x != self.par[x]:
            orig_par = self.par[x]
            self.par[x] = self.find(self.par[x])
            self.weight[x] *= self.weight[orig_par]
        return self.par[x]

    def union(self, x, y, value):
        self.add(x)
        self.add(y)
        root_x = self.find(x)
        root_y = self.find(y)

        if root_x != root_y:
            self.par[root_x] = root_y
            self.weight[root_x] = value * self.weight[y] / self.weight[x]

    def get_ratio(self, x, y):
        if x not in self.par or y not in self.par or self.find(x) != self.find(y):
            return -1.0
        return self.weight[x] / self.weight[y]

class Solution:
    def calcEquation(self, equations: List[List[str]], values: List[float], queries: List[List[str]]) -> List[float]:
        uf = UnionFind()

        for (a, b), value in zip(equations,values):
            uf.union(a, b, value)
        
        return [uf.get_ratio(a, b) for a, b in queries]
        