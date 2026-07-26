Leetcode - 153
  Optimal : 
    class Solution {
    public int findMin(int[] nums) {
        int s = 0;
        int e = nums.length - 1;
        int res = Integer.MAX_VALUE;

        while (s <= e) {
            int m = s + (e - s) / 2;

            res = Math.min(res, nums[m]);

            if (nums[m] > nums[e]) s = m + 1;
            else e = m - 1;
        }

        return res;
    }
}
