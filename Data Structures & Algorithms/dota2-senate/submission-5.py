class Solution:
    def predictPartyVictory(self, senate: str) -> str:
        d = r = 0
        arr = list(senate)

        for c in arr:
            if c == "R":
                r += 1
            else:
                d += 1

        dv = rv = 0

        while r > 0 and d > 0:
            for i in range(len(arr)):
                if arr[i] == "R":
                    if dv > 0:
                        dv -= 1
                        r -= 1
                        arr[i] = "."
                    else:
                        rv += 1
                elif arr[i] == "D":
                    if rv > 0:
                        rv -= 1
                        d -= 1
                        arr[i] = "."
                    else:
                        dv += 1

        return "Radiant" if r > 0 else "Dire"
