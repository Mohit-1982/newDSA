GFG
  class Solution {
    static int smallestSumSubarray(int a[], int size) {
        int sum = a[0];
        int minSum = sum;

        for (int i = 1; i < size; i++) {
            int take = a[i] + sum;
            int dont = a[i];

            sum = Math.min(take, dont);
            minSum = Math.min(sum, minSum);
        }

        return minSum;
    }
}
