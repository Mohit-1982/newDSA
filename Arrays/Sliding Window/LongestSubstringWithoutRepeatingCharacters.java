Leetcode - 3
  Optimal : 
    class Solution {
    public int lengthOfLongestSubstring(String s) {
        int low = 0;
        int res = 0;
        int high = 0;
        int n = s.length();
        Set<Character> set = new HashSet<>();

        for (high = 0; high < n; high++) {
            char ch = s.charAt(high);

            if (!set.contains(ch)) {
                set.add(ch);
                res = Math.max(res, high - low + 1);
            }else {
                while (set.contains(ch)) {
                    set.remove(s.charAt(low));
                    low++;
                }
                set.add(s.charAt(high));
            }
        }

        return res;
    }
}
