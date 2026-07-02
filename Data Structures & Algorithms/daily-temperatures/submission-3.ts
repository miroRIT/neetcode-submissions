class Solution {
    /**
     * @param {number[]} temperatures
     * @return {number[]}
     */
    dailyTemperatures(temperatures: number[]): number[] {
        let stack: number[][] = [];
        let res: number[] = new Array(temperatures.length).fill(0);
        for (let i = 0; i < temperatures.length; i++) {
            while (stack.length > 0 && temperatures[i] > stack[stack.length - 1][0]) {
                const [stkT, stkInd] = stack.pop();
                res[stkInd] = i - stkInd;
            }
            stack.push([temperatures[i], i]);
        }
        return res;
    }
}
