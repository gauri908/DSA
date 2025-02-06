class Solution {
    public int tupleSameProduct(int[] nums) {
        Map<Integer, Integer> countMap = new HashMap<>(); // a map to count the frequencies of the products
      
        // Iterate over all possible pairs of elements in the array
        for (int i = 1; i < nums.length; ++i) {
            for (int j = 0; j < i; ++j) {
                // Calculate the product of the current pair
                int product = nums[i] * nums[j];
              
                // Increment the count of this product in the map by 1,
                // or set it to 1 if it's the first time seeing this product
                countMap.merge(product, 1, Integer::sum);
            }
        }
      
        int answer = 0; // Initialize the answer to store the number of tuples
      
        // Iterate over the countMap values to calculate the number of tuples with the same product
        for (int frequency : countMap.values()) {
            // For every product, the number of 4-tuple combinations is frequency choose 2
            answer += frequency * (frequency - 1) / 2;
        }
      
        // Each combination can produce 8 tuples since (a*b = c*d) corresponds to 8 tuples
        // (a, b, c, d), (a, b, d, c), (b, a, c, d), (b, a, d, c), (c, d, a, b), (c, d, b, a), (d, c, a, b), (d, c, b, a)
        // Hence, we multiply the answer by 8 to get the total number of tuples
        return answer << 3; // The left shift by 3 is equivalent to multiplying by 8
    }
}
