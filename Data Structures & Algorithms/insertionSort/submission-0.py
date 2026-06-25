class Solution:
    def insertionSort(self, pairs: List[Pair]) -> List[List[Pair]]:
        self.pairs = pairs
        length = len(self.pairs)
        res = []
        for index in range(length):
            self.sort(index)
            res.append(list(self.pairs))
        return res
    
    def sort(self, index: int) -> None:
        j = index - 1
        while j >= 0 and self.pairs[j].key > self.pairs[j + 1].key:
            temp = self.pairs[j + 1]
            self.pairs[j + 1] = self.pairs[j]
            self.pairs[j] = temp
            j -= 1