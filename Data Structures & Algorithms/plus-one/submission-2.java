class Solution {
    public int[] plusOne(int[] digits) {
        int n = digits.length;
    
        // Loop backwards from the last digit
        for (int i = n - 1; i >= 0; i--) {
            if (digits[i] < 9) {
                digits[i]++;
                return digits; // We're done, no carry-over
            }
            // If it was a 9, set to 0 and continue to next digit
            digits[i] = 0;
        }
        
        // Edge case: If we are here, it means all digits were 9 (e.g., 999 -> 000)
        int[] newNumber = new int[n + 1];
        newNumber[0] = 1;
        return newNumber;
    }
}
