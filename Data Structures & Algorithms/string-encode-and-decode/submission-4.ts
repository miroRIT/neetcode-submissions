class Solution {
    /**
     * @param {string[]} strs
     * @returns {string}
     */
    encode(strs: string[]): string {
        let res: string = "";
        for (let s of strs) {
            let len: number = s.length;
            res += len + "#" + s;
        }
        return res;
    }

    /**
     * @param {string} str
     * @returns {string[]}
     */
    decode(str: string): string[] {
        let res: string[] = [];
        let i: number = 0;
        let n: number = str.length;
        while (i < n) {
            let j: number = i;
            while (str[j] !== "#") j++;
            let length = parseInt(str.substring(i, j));
            i = j + 1;
            j = i + length;
            res.push(str.substring(i, j));
            i = j;
        }
        return res;
    }
}
