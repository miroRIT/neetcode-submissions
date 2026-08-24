class FreqStack:
    def __init__(self):
        self.count = defaultdict(int)
        self.stack = [[]]

    def push(self, val: int) -> None:
        valCnt = 1 + self.count[val]
        self.count[val] = valCnt
        if valCnt == len(self.stack):
            self.stack.append([])
        self.stack[valCnt].append(val)

    def pop(self) -> int:
        res = self.stack[-1].pop()
        self.count[res] -= 1
        if not self.stack[-1]:
            self.stack.pop()
        return res


# Your FreqStack object will be instantiated and called as such:
# obj = FreqStack()
# obj.push(val)
# param_2 = obj.pop()
