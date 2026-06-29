class Solution:
    def getSum(self, a: int, b: int) -> int:
        mask = 0xFFFFFFFF

        while (b & mask) > 0:
            # Carry is where both bits are 1, shifted left by 1
            carry = (a & b) << 1
            # Sum without carry
            a = a ^ b
            # Assign carry to b to add in the next iteration
            b = carry

        # If b is 0, a contains the result.
        # The mask ensures we return a 32-bit signed integer result.
        return (a & mask) if b > 0 else a