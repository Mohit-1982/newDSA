GFG
  Optimal : 
    class Solution {
    int maxLength(int arr[]) {
        int sum = 0;
        int res = 0;
        int n = arr.length;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        
        for (int i = 0; i < n; i++) {
            sum += arr[i];
        
            if (map.containsKey(sum)) {
                res = Math.max(res, i - map.get(sum));
            }
            
            if (!map.containsKey(sum)) map.put(sum, i);
        }
        
        return res;
    }
}
