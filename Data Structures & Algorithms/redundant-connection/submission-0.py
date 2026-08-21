class Solution:
    def findRedundantConnection(self, edges: List[List[int]]) -> List[int]:
        adj = [[] for _ in range(len(edges) + 1)]

        def dfs(node, par):
            if visited[node]:
                return True
            
            visited[node] = True
            for nei in adj[node]:
                if nei == par:
                    continue
                if dfs(nei, node):
                    return True
            return False

        for u, v in edges:
            adj[u].append(v)
            adj[v].append(u)
            visited = [False] * (len(edges) + 1)

            if dfs(u, -1):
                return [u, v]
        
        return []