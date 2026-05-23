GFG
  Brute : 
    class Solution {
    public int longestSubarray(int[] arr, int k) {
        int maxLen = 0;
        int n = arr.length;
        
        for (int i = 0; i < n; i++) {
            int sum = 0;
            int len = 0;
            for (int j = i; j < n; j++) {
                sum += arr[j];
                len++;
                
                if (sum == k) {
                    maxLen = Math.max(maxLen, len);
                }
            }
        }
        
        return maxLen;
    }
}

Better :   
  class Solution {
    public int longestSubarray(int[] arr, int k) {
       int sum = 0;
       int len = 0;
       int n = arr.length;
       Map<Integer, Integer> map = new HashMap<>();
       
       for (int i = 0; i < n; i++) {
           sum += arr[i];
           int rem = sum - k;
           
           if (sum == k) {
               
               len = i + 1;
               
           } else if (map.containsKey(rem)) {
               
               len = Math.max(len, i - map.get(rem));
               
           }
           
           if (!map.containsKey(sum)) {//otherwise it will overwrite the first occu of this number
               map.put(sum, i);
           }
       }
       
       return len;
    }
}

Optimal : --> Only for +VE and zero case not when -VE are there in array
  class Solution {
    public int longestSubarray(int[] arr, int k) {
       int i = 0;
       int sum = 0;
       int len = 0;
       int n = arr.length;
       
        for (int j = 0; j < n; j++) {
            sum += arr[j];
            
            while (i <= j && sum > k){
                sum -= arr[i];
                i++;
            }
            
            if (sum == k) {
                len = Math.max(len, j - i + 1);
            }
        }
        
        return len;
    }
}
