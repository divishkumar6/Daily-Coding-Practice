// Problem: Check if Array Is Sorted and Rotated
// Difficulty: Easy
// Date: 2026-02-19
// Source: LeetCode #1752
// Solution Link: https://leetcode.com/problems/check-if-array-is-sorted-and-rotated/solutions/7590658/java-on-solution-using-pivot-minimum-ele-awz0/

/**
 * Problem Description:
 * Given an array nums, return true if the array was originally sorted in non-decreasing order,
 * then rotated some number of positions (including zero). Otherwise, return false.
 * There may be duplicates in the original array.
 * 
 * Note: An array A rotated by x positions results in an array B of the same length such that
 * B[i] == A[(i+x) % A.length] for every valid index i.
 * 
 * Example 1:
 * Input: nums = [3,4,5,1,2]
 * Output: true
 * Explanation: [1,2,3,4,5] is the original sorted array.
 * You can rotate the array by x = 2 positions to begin on the element of value 3: [3,4,5,1,2].
 * 
 * Example 2:
 * Input: nums = [2,1,3,4]
 * Output: false
 * Explanation: There is no sorted array once rotated that can make nums.
 * 
 * Example 3:
 * Input: nums = [1,2,3]
 * Output: true
 * Explanation: [1,2,3] is the original sorted array.
 * You can rotate the array by x = 0 positions (i.e. no rotation) to make nums.
 * 
 * Constraints:
 * - 1 <= nums.length <= 100
 * - 1 <= nums[i] <= 100
 */

class Solution {
    public boolean check(int[] nums) {
        int temp[] = new int[nums.length];
        int minVal = nums[0], minValPos = 0;
        
        // Find the minimum value position (pivot point)
        for(int i = 1; i < (nums.length); i++) {
            if(minVal < nums[i]) {
                continue;
            } else if(nums[i] == nums[i-1]) {
                continue;
            } else {
                minVal = nums[i];
                minValPos = i;
            }
        }
        
        // Rotate array starting from minimum position
        int i = 0, j = minValPos;
        while(true) {
            if(i == nums.length) {
                break;
            } else {
                if(j == nums.length) {
                    j = 0;
                }
                temp[i] = nums[j];
            }
            i++;
            j++;
        }
        
        // Check if rotated array is sorted
        for(int k = 0; k < (temp.length - 1); k++) {
            if(temp[k+1] < temp[k]) {
                return false;
            }
        }
        
        return true;
    }
    
    // Test cases
    public static void main(String[] args) {
        Solution solution = new Solution();
        
        // Test 1
        int[] nums1 = {3, 4, 5, 1, 2};
        System.out.println("Input: [3,4,5,1,2]");
        System.out.println("Output: " + solution.check(nums1));
        System.out.println("Expected: true\n");
        
        // Test 2
        int[] nums2 = {2, 1, 3, 4};
        System.out.println("Input: [2,1,3,4]");
        System.out.println("Output: " + solution.check(nums2));
        System.out.println("Expected: false\n");
        
        // Test 3
        int[] nums3 = {1, 2, 3};
        System.out.println("Input: [1,2,3]");
        System.out.println("Output: " + solution.check(nums3));
        System.out.println("Expected: true\n");
    }
}
