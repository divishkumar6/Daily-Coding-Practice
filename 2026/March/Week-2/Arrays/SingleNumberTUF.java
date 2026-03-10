// Problem: Single Number - I
// Difficulty: Easy
// Date: 2026-03-10
// Source: TUF+ (Take U Forward)

/**
 * Problem: Find the number that appears once while all others appear twice.
 * 
 * Example 1: nums = [1,2,2,4,3,1,4] → Output: 3
 * Example 2: nums = [5] → Output: 5
 * Example 3: nums = [1,3,10,3,5,1,5] → Output: 10
 * 
 * Constraints: 1 <= n <= 10^5, -3*10^5 <= nums[i] <= 3*10^5
 */

class Solution {
    public int singleNumber(int[] nums) {
        // XOR approach: duplicates cancel out, unique remains
        int xor = 0;
        
        for(int num : nums) {
            xor = xor ^ num;
        }
        
        return xor;
    }
    
    public static void main(String[] args) {
        Solution solution = new Solution();
        
        int[] nums1 = {1, 2, 2, 4, 3, 1, 4};
        System.out.println("Input: [1,2,2,4,3,1,4]");
        System.out.println("Output: " + solution.singleNumber(nums1));
        System.out.println("Expected: 3\n");
        
        int[] nums2 = {5};
        System.out.println("Input: [5]");
        System.out.println("Output: " + solution.singleNumber(nums2));
        System.out.println("Expected: 5\n");
        
        int[] nums3 = {1, 3, 10, 3, 5, 1, 5};
        System.out.println("Input: [1,3,10,3,5,1,5]");
        System.out.println("Output: " + solution.singleNumber(nums3));
        System.out.println("Expected: 10\n");
    }
}