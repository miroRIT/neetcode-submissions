class Solution {
    /**
     * @param {string[]} strs
     * @return {string[][]}
     */
    groupAnagrams(strs: string[]): string[][] {
        let res = new Map();
        for (const s of strs){
            const count = new Array(26).fill(0);

            for (let i = 0; i < s.length; i++){
                count[s.charCodeAt(i) - 97]++
            }

            const key = count.join('#');
            // If the key doesn't exist, initialize it
            if (!res.has(key)) {
                res.set(key, []);
            }
            
            // Add the current string to the corresponding list
            res.get(key).push(s);
        }
        return Array.from(res.values());
    }
}
