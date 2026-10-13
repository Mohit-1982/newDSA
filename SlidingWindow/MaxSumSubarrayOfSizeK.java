GFG
  Optimal:
    class Solution {
    public int maxSubarraySum(int[] arr, int k) {
        int n = arr.length;
        
        int i = 0;
        int j = 0;
        
        int sum = 0;
        int max = 0;
        
        if (n < k) return -1;
        
        while (j < n) {
            sum += arr[j];
            
            if (j - i + 1 < k) {
                j++;
            } else {
                max = Math.max (max, sum);
                sum -= arr[i];
                
                i++;
                j++;
            }
        }
        
        return max;
    }
}
