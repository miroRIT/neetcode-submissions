class Solution:
    def reorganizeString(self, s: str) -> str:
        freq = [0] * 26

        for char in s:
            freq[ord(char) - ord('a')] += 1
        
        max_id = freq.index(max(freq))
        max_freq = freq[max_id]

        if max_freq > (len(s) + 1) // 2:
            return ""
        
        res = [''] * len(s)
        id = 0
        max_char = chr(max_id + ord('a'))

        while freq[max_id] > 0:
            res[id] = max_char
            id += 2
            freq[max_id] -= 1
        
        for i in range(26):
            while freq[i] > 0:
                if id >= len(s):
                    id = 1
                res[id] = chr(i + ord('a'))
                id += 2
                freq[i] -= 1

        return ''.join(res)