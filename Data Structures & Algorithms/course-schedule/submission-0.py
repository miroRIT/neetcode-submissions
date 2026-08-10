class Solution:
    def canFinish(self, numCourses: int, prerequisites: List[List[int]]) -> bool:
        course = [0] * numCourses
        adj = [[] for i in range(numCourses)]
        for a, b in prerequisites:
            course[b] += 1
            adj[a].append(b) 
        
        q = deque()
        for i in range(numCourses):
            if course[i] == 0:
                q.append(i)
        
        finish = 0
        while q:
            node = q.popleft()
            finish += 1
            for nei in adj[node]:
                course[nei] -= 1
                if course[nei] == 0:
                    q.append(nei)

        return finish == numCourses        