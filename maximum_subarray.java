class Solution {
    public int maxAscendingSum(int[] nums) {
        int maxSum = 0; // This variable will store the maximum ascending subarray sum
        int currentSum = 0; // This variable will keep the current subarray sum
      
        // Iterate over all the elements in the array
        for (int i = 0; i < nums.length; ++i) {
            // Check if the current element is greater than the previous element or it is the first element
            if (i == 0 || nums[i] > nums[i - 1]) {
                currentSum += nums[i]; // Add the current element to the current sum
                maxSum = Math.max(maxSum, currentSum); // Update the maxSum with the larger of the two sums
            } else {
                currentSum = nums[i]; // If the current element is not greater then start a new subarray from the current element
            }
        }
        return maxSum; // Return the maximum sum of ascending subarray found
    }
}
