// Problem: Max Consecutive Ones
// Difficulty: Easy
// Date: 2026-02-25
// Source: LeetCode #485

/**
 * Problem Description:
 * Given a binary array nums, return the maximum number of consecutive 1's in the array.
 * 
 * Example 1:
 * Input: nums = [1,1,0,1,1,1]
 * Output: 3
 * Explanation: The first two digits or the last three digits are consecutive 1s.
 * The maximum number of consecutive 1s is 3.
 * 
 * Example 2:
 * Input: nums = [1,0,1,1,0,1]
 * Output: 2
 * 
 * Constraints:
 * - 1 <= nums.length <= 10^5
 * - nums[i] is either 0 or 1
 */

class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int count = 0, max = 0;
        
        // Iterate through the array
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] == 1) {
                // Increment count for consecutive 1s
                count++;
            } else {
                // When we hit a 0, update max if needed
                if(max <= count) {
                    max = count;
                }
                // Reset count
                count = 0;
            }
        }
        
        // Final check in case array ends with 1s
        if(max <= count) {
            max = count;
        }
        
        return max;
    }
    
    // Test cases
    public static void main(String[] args) {
        Solution solution = new Solution();
        
        // Test 1
        int[] nums1 = {1, 1, 0, 1, 1, 1};
        System.out.println("Test 1:");
        System.out.println("Input: [1,1,0,1,1,1]");
        System.out.println("Output: " + solution.findMaxConsecutiveOnes(nums1));
        System.out.println("Expected: 3\n");
        
        // Test 2
        int[] nums2 = {1, 0, 1, 1, 0, 1};
        System.out.println("Test 2:");
        System.out.println("Input: [1,0,1,1,0,1]");
        System.out.println("Output: " + solution.findMaxConsecutiveOnes(nums2));
        System.out.println("Expected: 2\n");
        
        // Test 3 - All ones
        int[] nums3 = {1, 1, 1, 1, 1};
        System.out.println("Test 3 (all ones):");
        System.out.println("Input: [1,1,1,1,1]");
        System.out.println("Output: " + solution.findMaxConsecutiveOnes(nums3));
        System.out.println("Expected: 5\n");
        
        // Test 4 - All zeros
        int[] nums4 = {0, 0, 0};
        System.out.println("Test 4 (all zeros):");
        System.out.println("Input: [0,0,0]");
        System.out.println("Output: " + solution.findMaxConsecutiveOnes(nums4));
        System.out.println("Expected: 0\n");
        
        // Test 5 - Single element
        int[] nums5 = {1};
        System.out.println("Test 5 (single element):");
        System.out.println("Input: [1]");
        System.out.println("Output: " + solution.findMaxConsecutiveOnes(nums5));
        System.out.println("Expected: 1\n");
    }
}
