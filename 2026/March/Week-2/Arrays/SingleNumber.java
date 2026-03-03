// Problem: Single Number
// Difficulty: Easy
// Date: 2026-03-03
// Source: LeetCode #136

/**
 * Problem: Find the element that appears once while all others appear twice.
 * Must use O(n) time and O(1) space.
 * 
 * Example 1: nums = [2,2,1] → Output: 1
 * Example 2: nums = [4,1,2,1,2] → Output: 4
 * Example 3: nums = [1] → Output: 1
 * 
 * Constraints: 1 <= nums.length <= 3*10^4, -3*10^4 <= nums[i] <= 3*10^4
 */

import java.util.*;

class Solution {
    // Solution 1: Sorting
    // Time: O(n log n), Space: O(1)
    public int singleNumberSort(int[] nums) {
        Arrays.sort(nums);
        int i = 1;
        
        while(i < nums.length) {
            if(nums[i] != nums[i-1]) {
                return nums[i-1];
            }
            i += 2;
        }
        
        return nums[nums.length-1];
    }
    
    // Solution 2: XOR (Optimal!)
    // Time: O(n), Space: O(1)
    public int singleNumber(int[] nums) {
        int xor = 0;
        
        for(int num : nums) {
            xor ^= num;
        }
        
        return xor;
    }
    
    public static void main(String[] args) {
        Solution solution = new Solution();
        
        int[] nums1 = {2, 2, 1};
        System.out.println("Input: [2,2,1]");
        System.out.println("Output: " + solution.singleNumber(nums1));
        System.out.println("Expected: 1\n");
        
        int[] nums2 = {4, 1, 2, 1, 2};
        System.out.println("Input: [4,1,2,1,2]");
        System.out.println("Output: " + solution.singleNumber(nums2));
        System.out.println("Expected: 4\n");
        
        int[] nums3 = {1};
        System.out.println("Input: [1]");
        System.out.println("Output: " + solution.singleNumber(nums3));
        System.out.println("Expected: 1\n");
    }
}
