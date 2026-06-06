GFG
  class Solution {
    public int longestKSubstr(String s, int k) {
        int low = 0;
        int res = 0;
        int n = s.length();
        Map<Character, Integer> map = new HashMap<>();
        
        for (int high = 0; high < n; high++) {
            char ch = s.charAt(high);
            
            map.put(ch, map.getOrDefault(ch, 0) + 1);
            
            while (map.size() > k) {
                char sh = s.charAt(low);
                
                if (map.get(sh) <= 1) map.remove(sh);
                else map.put(sh, map.get(sh) - 1);
                low++;
            }
            
            if (map.size() == k) res = Math.max(res, high - low + 1);
        }
        
        return (res == 0) ? -1 : res;
    }
}
