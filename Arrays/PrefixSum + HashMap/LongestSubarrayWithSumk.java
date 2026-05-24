GFG
  class Solution {
    public int longestSubarray(int[] arr, int k) {
        int len = 0;
        int sum = 0;
        int n = arr.length;
        HashMap<Integer, Integer> map = new HashMap<>();
        
        for (int i = 0; i < n; i++) {
            sum += arr[i];
            
            if (sum == k) {
                len = i + 1;
            }else {
                int rem = sum - k;
                
                if (map.containsKey(rem)) {
                    len = Math.max(len, i - map.get(rem));
                }
            }
            
            if (!map.containsKey(sum)) {
                map.put(sum, i);
            }
        }
        
        return len;
    }
}
