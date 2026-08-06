Leetcode - 1283
  Optimal : 
    class Solution {
    public int smallestDivisor(int[] nums, int threshold) {
        int max = -1;

        for (int ele : nums) max = Math.max(ele, max);

        int n = nums.length;
        int s = 1;
        int e = max;
        int res = -1;

        while (s <= e) {
            int m = s + (e - s) / 2;

            if (isPossible(nums, threshold, m)) {
                res = m;
                e = m - 1;
            } else {
                s = m + 1;
            }
        }

        return res;
    }

    public boolean isPossible(int[] nums, int thresh, int div) {
        int sumOfDiv = 0;

        for (int ele : nums) {
            sumOfDiv += Math.ceil((double) ele / div);
            //((ele / div) + (ele % 2)); this is wrong 
            //we have to use (ele / div) + (ele % div != 0 ? 1 : 0)
            //else it will give wrong answer

            if (sumOfDiv > thresh) return false;
        }

        return true;
    }
}
