class Solution:
    def lastStoneWeight(self, stones: List[int]) -> int:
        if not stones: return 0
        if len(stones) == 1: return stones[0]
        stones.sort(reverse = True)
        i1 = stones.pop(1)
        i0 = stones.pop(0)
        new_stone = i0- i1
        if new_stone > 0:
            stones.append(new_stone)
        return self.lastStoneWeight(stones)
