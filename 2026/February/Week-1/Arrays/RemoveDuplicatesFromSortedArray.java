// Problem: Remove Duplicates from Sorted Array
// Difficulty: Easy
// Date: 2026-02-20
// Source: LeetCode #26

/**
 * Problem Description:
 * Given an integer array nums sorted in non-decreasing order, remove the duplicates in-place
 * such that each unique element appears only once. The relative order of the elements should
 * be kept the same.
 * 
 * Consider the number of unique elements in nums to be k. After removing duplicates, return
 * the number of unique elements k. The first k elements of nums should contain the unique
 * numbers in sorted order. The remaining elements beyond index k - 1 can be ignored.
 * 
 * Example 1:
 * Input: nums = [1,1,2]
 * Output: 2, nums = [1,2,_]
 * Explanation: Your function should return k = 2, with the first two elements of nums being
 * 1 and 2 respectively. It does not matter what you leave beyond the returned k.
 * 
 * Example 2:
 * Input: nums = [0,0,1,1,1,2,2,3,3,4]
 * Output: 5, nums = [0,1,2,3,4,_,_,_,_,_]
 * Explanation: Your function should return k = 5, with the first five elements of nums being
 * 0, 1, 2, 3, and 4 respectively.
 * 
 * Constraints:
 * - 1 <= nums.length <= 3 * 10^4
 * - -100 <= nums[i] <= 100
 * - nums is sorted in non-decreasing order
 */

class Solution {
    public int removeDuplicates(int[] nums) {
        // Count unique elements
        int k = 1;
        for(int i = 1; i < nums.length; i++) {
            if(nums[i] == nums[i-1]) {
                continue;
            } else {
                k++;
            }
        }
        
        // Create temporary array to store unique elements
        int arr[] = new int[k];
        int j = 0;
        arr[0] = nums[0];
        
        // Fill array with unique elements
        for(int i = 1; i < nums.length; i++) {
            if(arr[j] != nums[i]) {
                arr[++j] = nums[i];
            }
        }
        
        // Copy unique elements back to original array
        for(int i = 0; i < nums.length; i++) {
            if(i < k) {
                nums[i] = arr[i];
            } else {
                nums[i] = 0;
            }
        }
        
        return k;
    }
    
    // Test cases
    public static void main(String[] args) {
        Solution solution = new Solution();
        
        // Test 1
        int[] nums1 = {1, 1, 2};
        int k1 = solution.removeDuplicates(nums1);
        System.out.println("Test 1:");
        System.out.println("Output k: " + k1);
        System.out.print("Modified array: [");
        for(int i = 0; i < k1; i++) {
            System.out.print(nums1[i] + (i < k1-1 ? "," : ""));
        }
        System.out.println("]");
        System.out.println("Expected: k = 2, nums = [1,2]\n");
        
        // Test 2
        int[] nums2 = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        int k2 = solution.removeDuplicates(nums2);
        System.out.println("Test 2:");
        System.out.println("Output k: " + k2);
        System.out.print("Modified array: [");
        for(int i = 0; i < k2; i++) {
            System.out.print(nums2[i] + (i < k2-1 ? "," : ""));
        }
        System.out.println("]");
        System.out.println("Expected: k = 5, nums = [0,1,2,3,4]\n");
    }
}
