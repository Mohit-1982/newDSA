Leetcode - 2090
  Brute : 
    class Solution {
    public int[] getAverages(int[] nums, int k) {
        int n = nums.length;
        int[] res = new int[n];
        Arrays.fill(res, -1);

        if (k >= n) return res;

        for (int i = 0; i < n; i++) {
            if (i - k < 0 || i + k >= n) continue;

            res[i] = avg(i, k, nums);
        }

        return res;
    }

    public int avg(int idx, int k, int[] nums) {
        long sum = 0;
        long totalEle = (2 * k) + 1;

        for (int i = idx - k; i <= idx + k; i++) {
            sum += (long) nums[i];
        }

        return (int) (sum / totalEle);
    }
}

Optimal : SlidingWindow + Cumulative Sum(prefix sum)
  class Solution {
    public int[] getAverages(int[] nums, int k) {
        int n = nums.length;
        int[] res = new int[n];
        Arrays.fill(res, -1);

        if (k >= n) return res;
        long[] prefix = prefixSum(nums);

        for (int i = 0; i < n; i++) {
            if (i - k < 0 || i + k >= n) continue;

            long sum = prefix[i + k] - ((i - k > 0) ? prefix[i - k - 1] : 0);
            res[i] = (int) (sum / (long)((2 * k) + 1));
        }

        return res;
    }

    public long[] prefixSum(int[] nums) {
        int n = nums.length;
        long[] prefix = new long[n];
        prefix[0] = nums[0];

        for (int i = 1; i < n; i++) {
            prefix[i] = prefix[i - 1] + (long) (nums[i]);
        }

        return prefix;
    }
}
