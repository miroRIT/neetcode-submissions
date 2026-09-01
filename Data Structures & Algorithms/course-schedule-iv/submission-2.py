class Solution:
    def checkIfPrerequisite(
        self, numCourses: int, prerequisites: List[List[int]], queries: List[List[int]]
    ) -> List[bool]:
        adj = [[] for _ in range(numCourses)]
        isPre = [[-1] * numCourses for _ in range(numCourses)]

        for pre, crs in prerequisites:
            adj[crs].append(pre)
            isPre[crs][pre] = True

        def dfs(crs, pre):
            if isPre[crs][pre] != -1:
                return isPre[crs][pre] == 1

            for p in adj[crs]:
                if p == pre or dfs(p, pre):
                    isPre[crs][pre] = 1
                    return True

            isPre[crs][pre] = 0
            return False

        res = []
        for u, v in queries:
            res.append(dfs(v, u))

        return res
