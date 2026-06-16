Leetcode - 3355

Optimal : 
  class Solution {
    public boolean isZeroArray(int[] nums, int[][] queries) {
        int n = nums.length;
        int q = queries.length;
        int[] dArr = new int[n];

        for (int i = 0; i < q; i++) {
            int l = queries[i][0];
            int r = queries[i][1];

            dArr[l] += 1;
            if (r + 1 < n) dArr[r + 1] -= 1;
        }

        int cumSum = 0;
        for (int i = 0; i < n; i++) {
            cumSum += dArr[i];
            dArr[i] = cumSum;

            if (dArr[i] < nums[i]) return false;
        }

        return true;
    }
}
