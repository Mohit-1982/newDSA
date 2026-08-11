Leetcode - 1539
  Optimal: 
    class Solution {
    public int findKthPositive(int[] arr, int k) {
        int n = arr.length;
        int s = 0;
        int e = n - 1;

        while (s <= e) {
            int m = s + (e - s) / 2;
            int missing = arr[m] - m - 1;

            if (missing < k) s = m + 1;
            else e = m - 1;
        }

        // return arr[e] + (k - (arr[e] - e - 1))
        // return k + e + 1;
        return s + k;
    }
}
