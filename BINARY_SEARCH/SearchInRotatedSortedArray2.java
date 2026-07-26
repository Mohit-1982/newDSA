Leetcode - 81 
  Optimal: 
    class Solution {
    public boolean search(int[] nums, int target) {
        int s = 0;
        int e = nums.length - 1;

        while (s <= e) {
            int m = s + (e - s) / 2;

            if (nums[m] == target) return true;
            else if (nums[s] == nums[m] && nums[m] == nums[e]) {
                s++;
                e--;
            } else if (nums[m] <= nums[e]) {
                if (nums[m] < target && nums[e] >= target) s = m + 1;
                else e = m - 1;
            } else {
                if (nums[s] <= target && nums[m] > target) e = m - 1;
                else s = m + 1;
            }
        }

        return false;
    }
}
