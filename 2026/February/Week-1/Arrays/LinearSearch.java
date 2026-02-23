// Problem: Linear Search
// Difficulty: Easy
// Date: 2026-02-23
// Source: TUF+ (Take U Forward)

/**
 * Problem Description:
 * Given an array of integers nums and an integer target, find the smallest index
 * (0 based indexing) where the target appears in the array. If the target is not
 * found in the array, return -1.
 * 
 * Example 1:
 * Input: nums = [2, 3, 4, 5, 3], target = 3
 * Output: 1
 * Explanation: The first occurrence of 3 in nums is at index 1
 * 
 * Example 2:
 * Input: nums = [2, -4, 4, 0, 10], target = 6
 * Output: -1
 * Explanation: The value 6 does not occur in the array, hence output is -1
 * 
 * Example 3:
 * Input: nums = [1, 3, 5, -4, 1], target = 1
 * Output: 0
 * Explanation: The first occurrence of 1 is at index 0
 * 
 * Constraints:
 * - 1 <= nums.length <= 10^5
 * - -10^4 <= nums[i] <= 10^4
 * - -10^4 <= target <= 10^4
 */

class Solution {
    public int linearSearch(int nums[], int target) {
        // Iterate through array from start to end
        for(int i = 0; i < nums.length; i++) {
            // If current element matches target, return index
            if(nums[i] == target) {
                return i;
            }
        }
        // Target not found, return -1
        return -1;
    }
    
    // Test cases
    public static void main(String[] args) {
        Solution solution = new Solution();
        
        // Test 1
        int[] nums1 = {2, 3, 4, 5, 3};
        int target1 = 3;
        System.out.println("Test 1:");
        System.out.println("Input: nums = [2,3,4,5,3], target = " + target1);
        System.out.println("Output: " + solution.linearSearch(nums1, target1));
        System.out.println("Expected: 1\n");
        
        // Test 2
        int[] nums2 = {2, -4, 4, 0, 10};
        int target2 = 6;
        System.out.println("Test 2:");
        System.out.println("Input: nums = [2,-4,4,0,10], target = " + target2);
        System.out.println("Output: " + solution.linearSearch(nums2, target2));
        System.out.println("Expected: -1\n");
        
        // Test 3
        int[] nums3 = {1, 3, 5, -4, 1};
        int target3 = 1;
        System.out.println("Test 3:");
        System.out.println("Input: nums = [1,3,5,-4,1], target = " + target3);
        System.out.println("Output: " + solution.linearSearch(nums3, target3));
        System.out.println("Expected: 0\n");
        
        // Test 4 - Edge case: single element
        int[] nums4 = {5};
        int target4 = 5;
        System.out.println("Test 4 (single element):");
        System.out.println("Input: nums = [5], target = " + target4);
        System.out.println("Output: " + solution.linearSearch(nums4, target4));
        System.out.println("Expected: 0\n");
    }
}
