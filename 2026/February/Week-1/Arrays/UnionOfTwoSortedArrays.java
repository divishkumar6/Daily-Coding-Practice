// Problem: Union of Two Sorted Arrays
// Difficulty: Easy
// Date: 2026-02-25
// Source: TUF+ (Take U Forward)

/**
 * Problem Description:
 * Given two sorted arrays nums1 and nums2, return an array that contains the union
 * of these two arrays. The elements in the union must be in ascending order.
 * 
 * The union of two arrays is an array where all values are distinct and are present
 * in either the first array, the second array, or both.
 * 
 * Example 1:
 * Input: nums1 = [1, 2, 3, 4, 5], nums2 = [1, 2, 7]
 * Output: [1, 2, 3, 4, 5, 7]
 * Explanation: The elements 1, 2 are common to both, 3, 4, 5 are from nums1 and 7 is from nums2
 * 
 * Example 2:
 * Input: nums1 = [3, 4, 6, 7, 9, 9], nums2 = [1, 5, 7, 8, 8]
 * Output: [1, 3, 4, 5, 6, 7, 8, 9]
 * Explanation: The element 7 is common to both, 3, 4, 6, 9 are from nums1 and 1, 5, 8 is from nums2
 * 
 * Constraints:
 * - 1 <= nums1.length, nums2.length <= 1000
 * - -10^4 <= nums1[i], nums2[i] <= 10^4
 * - Both nums1 and nums2 are sorted in non-decreasing order
 */

import java.util.*;

class Solution {
    public int[] unionArray(int[] nums1, int[] nums2) {
        // Create result array with maximum possible size
        int res[] = new int[nums1.length + nums2.length];
        int i = 0, j = 0;
        
        // Merge both arrays into result array
        while (true) {
            if (i == nums1.length) {
                res[i + j] = nums2[j];
                j++;
            } else {
                res[i + j] = nums1[i];
                i++;
            }
            
            // Break when both arrays are fully processed
            if (i == nums1.length && j == nums2.length) {
                break;
            }
        }
        
        // Sort the merged array
        Arrays.sort(res);
        
        // Remove duplicates using two-pointer technique
        int k = 0;
        for (int l = 1; l < res.length; l++) {
            if (res[l] != res[k]) {
                k++;
                res[k] = res[l];
            }
        }
        
        // Return array with only unique elements
        return Arrays.copyOf(res, k + 1);
    }
    
    // Test cases
    public static void main(String[] args) {
        Solution solution = new Solution();
        
        // Test 1
        int[] nums1_1 = {1, 2, 3, 4, 5};
        int[] nums2_1 = {1, 2, 7};
        System.out.println("Test 1:");
        System.out.println("Input: nums1 = [1,2,3,4,5], nums2 = [1,2,7]");
        System.out.print("Output: ");
        System.out.println(Arrays.toString(solution.unionArray(nums1_1, nums2_1)));
        System.out.println("Expected: [1, 2, 3, 4, 5, 7]\n");
        
        // Test 2
        int[] nums1_2 = {3, 4, 6, 7, 9, 9};
        int[] nums2_2 = {1, 5, 7, 8, 8};
        System.out.println("Test 2:");
        System.out.println("Input: nums1 = [3,4,6,7,9,9], nums2 = [1,5,7,8,8]");
        System.out.print("Output: ");
        System.out.println(Arrays.toString(solution.unionArray(nums1_2, nums2_2)));
        System.out.println("Expected: [1, 3, 4, 5, 6, 7, 8, 9]\n");
        
        // Test 3 - No common elements
        int[] nums1_3 = {1, 3, 5};
        int[] nums2_3 = {2, 4, 6};
        System.out.println("Test 3 (no common elements):");
        System.out.println("Input: nums1 = [1,3,5], nums2 = [2,4,6]");
        System.out.print("Output: ");
        System.out.println(Arrays.toString(solution.unionArray(nums1_3, nums2_3)));
        System.out.println("Expected: [1, 2, 3, 4, 5, 6]\n");
        
        // Test 4 - All common elements
        int[] nums1_4 = {1, 2, 3};
        int[] nums2_4 = {1, 2, 3};
        System.out.println("Test 4 (all common elements):");
        System.out.println("Input: nums1 = [1,2,3], nums2 = [1,2,3]");
        System.out.print("Output: ");
        System.out.println(Arrays.toString(solution.unionArray(nums1_4, nums2_4)));
        System.out.println("Expected: [1, 2, 3]\n");
    }
}
