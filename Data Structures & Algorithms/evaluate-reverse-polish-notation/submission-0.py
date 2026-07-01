class Solution:
    def evalRPN(self, tokens: List[str]) -> int:
        stack = []
        i = 0
        n = len(tokens)
        while i < n:
            if tokens[i] in ['/', '*', '+', '-']:
                a = stack.pop()
                b = stack.pop()
                if tokens[i] == '+':
                    new_elem = a + b
                elif tokens[i] == '-':
                    new_elem = b - a
                elif tokens[i] == '*':
                    new_elem = a * b
                elif tokens[i] == '/':
                    new_elem = int(float(b) / a)
                stack.append(new_elem) 
            else:
                stack.append(int(tokens[i]))
            i += 1
        return stack.pop()     