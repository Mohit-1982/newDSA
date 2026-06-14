GFG
  Brute : 
    class Solution {
    public long subarrayXor(int arr[], int k) {
        int res = 0;
        int n = arr.length;
        
        for (int i = 0; i < n; i++) {
            int xor = 0;
            for (int j = i; j < n; j++) {
                xor ^= arr[j];
                if (xor == k) res++;
            }
        }
        
        return res;
    }
}

Optimal : 
class Solution {
    public long subarrayXor(int arr[], int k) {
        int res = 0;
        int xor = 0;
        int n = arr.length;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        
        for (int i = 0; i < n; i++) {
            xor ^= arr[i];
            int x = xor ^ k;
            
            if (map.containsKey(x)) res += map.get(x);
            map.put(xor, map.getOrDefault(xor, 0) + 1);
        }
        
        return res;
    }
}
