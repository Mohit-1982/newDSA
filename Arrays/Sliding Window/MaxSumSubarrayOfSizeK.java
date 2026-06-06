GFG
  Optimal :   
    class Solution {
    public int maxSubarraySum(int[] arr, int k) {
        int sum = 0;
        int n = arr.length;
        
        for (int i = 0; i < k; i++) {
            sum += arr[i];
        }
        
        int i = 0;
        int j = k;
        int maxSum = sum;
        
        while (j < n) {
            sum = sum + arr[j] - arr[i];
            maxSum = Math.max(sum, maxSum);
            j++;
            i++;
        }
        
        return maxSum;
    }
}
