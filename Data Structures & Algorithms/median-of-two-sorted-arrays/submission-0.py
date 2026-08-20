class Solution:
    def findMedianSortedArrays(self, nums1: List[int], nums2: List[int]) -> float:
        A = nums1
        B = nums2
        
        total = len(A) + len(B)
        half = total // 2

        if len(A) > len(B):
            A, B = B, A

        n1 = len(A)
        n2 = len(B)

        l, r = 0, n1 - 1

        while True:
            i = (l + r) // 2
            j = half - i - 2
            Al = A[i] if i >=0 else float("-inf")
            Ar = A[i + 1] if (i + 1) < n1 else float("inf")
            Bl = B[j] if j >= 0 else float("-inf")
            Br = B[j + 1] if (j + 1) < n2 else float("inf")

            if Al <= Br and Bl <= Ar:
                if total % 2:
                    return min(Ar, Br)
                return (max(Al, Bl) + min(Ar, Br)) / 2
            elif Al > Bl:
                r = i - 1
            else:
                l = i + 1