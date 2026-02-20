// Problem: Rotate Array
// Difficulty: Medium
// Date: 2026-02-20
// Source: LeetCode #189

/**
 * Problem Description:
 * Given an integer array nums, rotate the array to the right by k steps, where k is non-negative.
 * 
 * Example 1:
 * Input: nums = [1,2,3,4,5,6,7], k = 3
 * Output: [5,6,7,1,2,3,4]
 * Explanation:
 * rotate 1 steps to the right: [7,1,2,3,4,5,6]
 * rotate 2 steps to the right: [6,7,1,2,3,4,5]
 * rotate 3 steps to the right: [5,6,7,1,2,3,4]
 * 
 * Example 2:
 * Input: nums = [-1,-100,3,99], k = 2
 * Output: [3,99,-1,-100]
 * Explanation:
 * rotate 1 steps to the right: [99,-1,-100,3]
 * rotate 2 steps to the right: [3,99,-1,-100]
 * 
 * Constraints:
 * - 1 <= nums.length <= 10^5
 * - -2^31 <= nums[i] <= 2^31 - 1
 * - 0 <= k <= 10^5
 * 
 * Follow up:
 * - Try to come up with as many solutions as you can. There are at least three different ways.
 * - Could you do it in-place with O(1) extra space?
 */

class Solution {
    public void rotate(int[] nums, int k) {
        // Create temporary array to store rotated elements
        int temp[] = new int[nums.length];
        
        // Calculate new position for each element
        // (i + k) % nums.length handles wrap-around
        for(int i = 0; i < nums.length; i++) {
            temp[(i + k) % (nums.length)] = nums[i];
        }
        
        // Copy rotated elements back to original array
        for(int i = 0; i < nums.length; i++) {
            nums[i] = temp[i];
        }
    }
    
    // Test cases
    public static void main(String[] args) {
        Solution solution = new Solution();
        
        // Test 1
        int[] nums1 = {1, 2, 3, 4, 5, 6, 7};
        int k1 = 3;
        System.out.println("Test 1:");
        System.out.print("Input: nums = [1,2,3,4,5,6,7], k = " + k1);
        solution.rotate(nums1, k1);
        System.out.print("\nOutput: [");
        for(int i = 0; i < nums1.length; i++) {
            System.out.print(nums1[i] + (i < nums1.length-1 ? "," : ""));
        }
        System.out.println("]");
        System.out.println("Expected: [5,6,7,1,2,3,4]\n");
        
        // Test 2
        int[] nums2 = {-1, -100, 3, 99};
        int k2 = 2;
        System.out.println("Test 2:");
        System.out.print("Input: nums = [-1,-100,3,99], k = " + k2);
        solution.rotate(nums2, k2);
        System.out.print("\nOutput: [");
        for(int i = 0; i < nums2.length; i++) {
            System.out.print(nums2[i] + (i < nums2.length-1 ? "," : ""));
        }
        System.out.println("]");
        System.out.println("Expected: [3,99,-1,-100]\n");
        
        // Test 3 - Edge case: k larger than array length
        int[] nums3 = {1, 2, 3};
        int k3 = 4;
        System.out.println("Test 3 (k > length):");
        System.out.print("Input: nums = [1,2,3], k = " + k3);
        solution.rotate(nums3, k3);
        System.out.print("\nOutput: [");
        for(int i = 0; i < nums3.length; i++) {
            System.out.print(nums3[i] + (i < nums3.length-1 ? "," : ""));
        }
        System.out.println("]");
        System.out.println("Expected: [3,1,2] (k=4 is same as k=1 for length 3)\n");
    }
}
