class Solution {
    /**
     * @param {string[]} tokens
     * @return {number}
     */
    evalRPN(tokens) {
        const stk = [];
        for (const s of tokens) {
            if (s === "+") stk.push(stk.pop() + stk.pop());
            else if (s === "*") stk.push(stk.pop() * stk.pop());
            else if (s === "/") {
                const a = stk.pop();
                const b = stk.pop();
                stk.push(Math.trunc(b / a));
            } else if (s === "-") {
                const a = stk.pop();
                const b = stk.pop();
                stk.push(b - a);
            } else stk.push(parseInt(s));
        }
        return stk.pop();
    }
}
