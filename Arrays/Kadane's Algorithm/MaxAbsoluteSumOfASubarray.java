Leetcode - 1749
  Optimal :   
    class Solution {
    public int maxAbsoluteSum(int[] nums) {
        int max = nums[0];
        int min = nums[0];
        int maxRes = nums[0];
        int minRes = nums[0];

        for (int i = 1; i < nums.length; i++) {
            int v1 = max + nums[i];
            int v2 = min + nums[i];

            max = Math.max(v1, nums[i]);
            min = Math.min(v2, nums[i]);

            maxRes = Math.max(maxRes, max);
            minRes = Math.min(minRes, min);
        }

        return Math.max(Math.abs(maxRes), Math.abs(minRes));
    }
}
