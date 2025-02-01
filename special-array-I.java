class Solution {
    public boolean isArraySpecial(int[] nums) {
        // Iterate through the array starting from the second element
        for (int i = 1; i < nums.length; ++i) {
            // Check if the current and previous elements are both even or both odd
            if (nums[i] % 2 == nums[i - 1] % 2) {
                // If so, the array is not special, return false
                return false;
            }
        }
        // If no consecutive elements have the same parity, return true
        return true;
    }
}
