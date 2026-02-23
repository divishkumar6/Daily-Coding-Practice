// Problem: Move Zeroes
// Difficulty: Easy
// Date: 2026-02-23
// Source: LeetCode #283

/**
 * Problem Description:
 * Given an integer array nums, move all 0's to the end of it while maintaining
 * the relative order of the non-zero elements.
 * 
 * Note: You must do this in-place without making a copy of the array.
 * 
 * Example 1:
 * Input: nums = [0,1,0,3,12]
 * Output: [1,3,12,0,0]
 * 
 * Example 2:
 * Input: nums = [0]
 * Output: [0]
 * 
 * Constraints:
 * - 1 <= nums.length <= 10^4
 * - -2^31 <= nums[i] <= 2^31 - 1
 * 
 * Follow up: Could you minimize the total number of operations done?
 */

class Solution {
    public void moveZeroes(int[] nums) {
        // Create temporary array to store non-zero elements
        int temp[] = new int[nums.length];
        
        // Copy all non-zero elements to temp array
        for(int i = 0, j = 0; i < nums.length; i++) {
            if(nums[i] != 0) {
                temp[j] = nums[i];
                j++;
            }
        }
        
        // Copy temp array back to original (remaining positions are already 0)
        for(int i = 0; i < nums.length; i++) {
            nums[i] = temp[i];
        }
    }
    
    // Test cases
    public static void main(String[] args) {
        Solution solution = new Solution();
        
        // Test 1
        int[] nums1 = {0, 1, 0, 3, 12};
        System.out.println("Test 1:");
        System.out.print("Input: [0,1,0,3,12]");
        solution.moveZeroes(nums1);
        System.out.print("\nOutput: [");
        for(int i = 0; i < nums1.length; i++) {
            System.out.print(nums1[i] + (i < nums1.length-1 ? "," : ""));
        }
        System.out.println("]");
        System.out.println("Expected: [1,3,12,0,0]\n");
        
        // Test 2
        int[] nums2 = {0};
        System.out.println("Test 2:");
        System.out.print("Input: [0]");
        solution.moveZeroes(nums2);
        System.out.print("\nOutput: [");
        for(int i = 0; i < nums2.length; i++) {
            System.out.print(nums2[i] + (i < nums2.length-1 ? "," : ""));
        }
        System.out.println("]");
        System.out.println("Expected: [0]\n");
        
        // Test 3
        int[] nums3 = {1, 2, 3, 4, 5};
        System.out.println("Test 3 (no zeros):");
        System.out.print("Input: [1,2,3,4,5]");
        solution.moveZeroes(nums3);
        System.out.print("\nOutput: [");
        for(int i = 0; i < nums3.length; i++) {
            System.out.print(nums3[i] + (i < nums3.length-1 ? "," : ""));
        }
        System.out.println("]");
        System.out.println("Expected: [1,2,3,4,5]\n");
    }
}
