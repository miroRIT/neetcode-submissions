class Solution:
    def lemonadeChange(self, bills: List[int]) -> bool:
        f, t = 0, 0

        for bill in bills:
            if bill == 5:
                f += 1
            elif bill == 10:
                f -= 1
                t += 1
            elif t > 0:
                t -= 1
                f -= 1
            else:
                f -= 3
            
            if f < 0:
                return False
        
        return True