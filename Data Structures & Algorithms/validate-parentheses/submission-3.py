class Solution:
    def isValid(self, s: str) -> bool:
        stk = deque()

        for elem in s:
            if elem in ('[' , '{', '('):
                stk.append(elem)
            else:
                brak = stk.pop() if len(stk) else ''
                if (elem == ']' and brak != '[') or (elem == '}' and brak != '{') or (elem == ')' and brak != '('):
                    return False
        return True if len(stk) == 0 else False