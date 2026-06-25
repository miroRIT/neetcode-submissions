class Solution:
    def isPalindrome(self, s: str) -> bool:
            
        cleaned = ''.join(char.lower() for char in s if char.isalnum())
        
        # Check if cleaned string is equal to its reverse
        return cleaned == cleaned[::-1]
        