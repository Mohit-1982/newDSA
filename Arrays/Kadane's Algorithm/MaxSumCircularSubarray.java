Leetcode - 918
  Optimal :   
    class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        int sum = nums[0];
        int max = nums[0];
        int min = nums[0];
        int maxSum = nums[0];
        int minSum = nums[0];

        for (int i = 1; i < nums.length; i++) {
            sum += nums[i];
            int v1 = max + nums[i];
            int v2 = min + nums[i];

            max = Math.max(v1, nums[i]);
            min = Math.min(v2, nums[i]);
            maxSum = Math.max(max, maxSum);
            minSum = Math.min(min, minSum);
        }

        if (maxSum < 0) return maxSum;
        return Math.max(maxSum, sum - minSum);
    }
}
