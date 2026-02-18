// Problem: Second Largest Element
// Difficulty: Easy
// Date: 2026-02-18
// Source: Custom/Practice

/**
 * Problem Description:
 * Given an array of integers nums, return the second-largest element in the array.
 * If the second-largest element does not exist, return -1.
 * 
 * Example 1:
 * Input: nums = [8, 8, 7, 6, 5]
 * Output: 7
 * Explanation: The largest value in nums is 8, the second largest is 7
 * 
 * Example 2:
 * Input: nums = [10, 10, 10, 10, 10]
 * Output: -1
 * Explanation: The only value in nums is 10, so there is no second largest value
 * 
 * Constraints:
 * - 1 <= nums.length <= 10^5
 * - -10^4 <= nums[i] <= 10^4
 * - nums may contain duplicate elements
 */

import java.util.Arrays;

class Solution {
    public int secondLargestElement(int[] nums) {
        Arrays.sort(nums);
        int max1 = 0, max2 = -1, len = nums.length;
        
        for(int i = 1; i < len; i++) {
            if(nums[len-i] > nums[len-(i+1)]) {
                max1 = nums[len - i];
                max2 = nums[len - (i + 1)];
                break;
            } else if(nums[len-i] < nums[len-(i+1)]) {
                max2 = nums[len - i];
                max1 = nums[len - (i + 1)];
                break;
            }
        }
        
        return max2;
    }
    
    // Test cases
    public static void main(String[] args) {
        Solution solution = new Solution();
        
        // Test 1
        int[] nums1 = {8, 8, 7, 6, 5};
        System.out.println("Input: " + Arrays.toString(nums1));
        System.out.println("Output: " + solution.secondLargestElement(nums1));
        System.out.println("Expected: 7\n");
        
        // Test 2
        int[] nums2 = {10, 10, 10, 10, 10};
        System.out.println("Input: " + Arrays.toString(nums2));
        System.out.println("Output: " + solution.secondLargestElement(nums2));
        System.out.println("Expected: -1\n");
    }
}
