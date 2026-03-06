// Problem: Check if Binary String Has at Most One Segment of Ones
// Difficulty: Easy
// Date: 2026-03-06
// Source: LeetCode #1784

/**
 * Problem: Return true if binary string has at most one contiguous segment of 1s.
 * String has no leading zeros (starts with '1').
 * 
 * Example 1: s = "1001" → false (ones not contiguous)
 * Example 2: s = "110" → true (one segment of ones)
 * 
 * Constraints: 1 <= s.length <= 100, s[i] is '0' or '1', s[0] is '1'
 */

class Solution {
    public boolean checkOnesSegment(String s) {
        int count = 1;
        char[] charArray = s.toCharArray();
        
        if(s.length() == 1) {
            return true;
        }
        
        for(char string : charArray) {
            if(count == 1 && string == '1') {
                count = 1;
                continue;
            } else if(count != 1 && string == '1') {
                count = 2;
                return false;
            } else {
                count = 0;
            }
        }
        
        if(count > 1) {
            return false;
        } else {
            return true;
        }
    }
    
    // Simpler approach: Check if "01" exists
    // If "01" exists, it means 1s appear after 0s (multiple segments)
    public boolean checkOnesSegmentSimple(String s) {
        return !s.contains("01");
    }
    
    public static void main(String[] args) {
        Solution solution = new Solution();
        
        System.out.println("Input: \"1001\"");
        System.out.println("Output: " + solution.checkOnesSegment("1001"));
        System.out.println("Expected: false\n");
        
        System.out.println("Input: \"110\"");
        System.out.println("Output: " + solution.checkOnesSegment("110"));
        System.out.println("Expected: true\n");
        
        System.out.println("Input: \"1\"");
        System.out.println("Output: " + solution.checkOnesSegment("1"));
        System.out.println("Expected: true\n");
        
        // Test simple approach
        System.out.println("Simple approach test:");
        System.out.println("\"1001\": " + solution.checkOnesSegmentSimple("1001"));
        System.out.println("\"110\": " + solution.checkOnesSegmentSimple("110"));
    }
}
