// Problem: Find Missing Number
// Difficulty: Easy
// Date: 2026-03-03
// Source: TUF+ (Take U Forward)

/**
 * Problem: Given an array of size n with distinct values in range [0, n],
 * return the only missing number.
 * 
 * Example 1: nums = [0,2,3,1,4] → Output: 5
 * Example 2: nums = [0,1,2,4,5,6] → Output: 3
 * 
 * Constraints: 1 <= n <= 10^4, 0 <= nums[i] <= n, all unique
 */

import java.util.*;

class Solution {
    // Current Solution: Sort and Find
    // Time: O(n log n), Space: O(1)
    public int missingNumber(int[] nums) {
        Arrays.sort(nums);
        
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] != i) {
                return i;
            }
        }
        
        return nums.length;
    }
    
    // Optimal Solution 1: Sum Formula
    // Time: O(n), Space: O(1)
    public int missingNumberSum(int[] nums) {
        int n = nums.length;
        int expectedSum = n * (n + 1) / 2;  // Sum of 0 to n
        int actualSum = 0;
        
        for(int num : nums) {
            actualSum += num;
        }
        
        return expectedSum - actualSum;
    }
    
    // Optimal Solution 2: XOR Method
    // Time: O(n), Space: O(1)
    public int missingNumberXOR(int[] nums) {
        int xor = nums.length;  // Start with n
        
        for(int i = 0; i < nums.length; i++) {
            xor ^= i ^ nums[i];  // XOR with index and value
        }
        
        return xor;
    }
    
    public static void main(String[] args) {
        Solution solution = new Solution();
        
        int[] nums1 = {0, 2, 3, 1, 4};
        System.out.println("Input: [0,2,3,1,4]");
        System.out.println("Sort method: " + solution.missingNumber(nums1));
        System.out.println("Sum method: " + solution.missingNumberSum(nums1));
        System.out.println("XOR method: " + solution.missingNumberXOR(nums1));
        System.out.println("Expected: 5\n");
        
        int[] nums2 = {0, 1, 2, 4, 5, 6};
        System.out.println("Input: [0,1,2,4,5,6]");
        System.out.println("Output: " + solution.missingNumberSum(nums2));
        System.out.println("Expected: 3\n");
    }
}
