class Solution {
    public int[] lexicographicallySmallestArray(int[] nums, int limit) {
        // Get the length of the original array.
        int n = nums.length;
      
        // Create an array of indices of the given array.
        Integer[] indices = new Integer[n];
        for (int i = 0; i < n; ++i) {
            indices[i] = i;
        }
        // Sort the indices based on the values in 'nums' they point to.
        Arrays.sort(indices, Comparator.comparingInt(i -> nums[i]));
      
        // Prepare an array to store the answer.
        int[] answer = new int[n];
      
        // Loop over the indices array.
        for (int i = 0; i < n;) {
            // Find a contiguous subsequence of indices where each pair of consecutive
            // numbers has a difference less than or equal to 'limit'.
            int j = i + 1;
            while (j < n && nums[indices[j]] - nums[indices[j - 1]] <= limit) {
                ++j;
            }
          
            // Copy the subrange of indices [i, j) to a temporary array 'tempIndices'.
            Integer[] tempIndices = Arrays.copyOfRange(indices, i, j);
          
            // Sort the temporary indices array in natural order, effectively sorting by
            // their original positions in 'nums'.
            Arrays.sort(tempIndices, Comparator.naturalOrder());
          
            // Populate the 'answer' array with values from 'nums' using the sorted
            // temporary indices.
            for (int k = i; k < j; ++k) {
                answer[tempIndices[k - i]] = nums[indices[k]];
            }
          
            // Move to the next subsequence.
            i = j;
        }
      
        return answer;
    }
}
