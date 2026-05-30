Leetcode - 724
  Better : 
    class Solution {
    public int pivotIndex(int[] nums) {
        int n = nums.length;
        int[] prefix = prefixSum(nums);

        for (int i = 0; i < n; i++) {
            int leftSum = (i > 0) ? prefix[i - 1] : 0;
            int rightSum = (i < n - 1) ? prefix[n - 1] - prefix[i] : 0;

            if (leftSum == rightSum) return i;
        }

        return -1;
    }

    public int[] prefixSum(int[] nums) {
        int n = nums.length;
        int[] prefix = new int[n];
        prefix[0] = nums[0];

        for (int i = 1; i < n; i++) {
            prefix[i] = prefix[i - 1] + nums[i];
        }

        return prefix;
    }
}

Optimal : 
  class Solution {
    public int pivotIndex(int[] nums) {
        int left = 0;
        int n = nums.length;
        int totalSum = Arrays.stream(nums).sum();

        for (int i = 0; i < n; i++) {
            if (left == totalSum - left - nums[i]) return i;

            left += nums[i];
        }

        return -1;
    }
}
