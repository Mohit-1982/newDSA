Leetcode - 862
  Brute : 
    class Solution {
    public int shortestSubarray(int[] nums, int k) {
        int n = nums.length;
        int len = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            int sum = 0;

            for (int j = i; j < n; j++) {
                sum += nums[j];
                if (sum >= k) {
                    len = Math.min(len, j - i + 1);
                }
            }
        }

        return (len == Integer.MAX_VALUE) ? -1 : len;
    }
}

Optimal : 
  
