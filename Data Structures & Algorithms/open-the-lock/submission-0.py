class Solution:
    def openLock(self, deadends: List[str], target: str) -> int:
        if "0000" in deadends:
            return -1

        visited = set(deadends)
        visited.add("0000")

        q = deque([("0000", 0)])

        while q:
            curr, turns = q.popleft()

            if curr == target:
                return turns

            for i in range(4):
                digit = int(curr[i])
                for move in [-1, 1]:
                    new_dig = (digit + move) % 10
                    next_state = curr[:i] + str(new_dig) + curr[i + 1:]

                    if next_state not in visited:
                        visited.add(next_state)
                        q.append((next_state, turns + 1))

        return -1