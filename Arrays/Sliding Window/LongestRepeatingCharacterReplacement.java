Leetcode - 424
  Better : 
    class Solution {
    public int characterReplacement(String s, int k) {
        int[] hash = new int[26];
        int n = s.length();
        int maxFreq = 0;
        int low = 0;
        int res = 0;

        for (int high = 0; high < n; high++) {
            char ch = s.charAt(high);

            hash[ch - 'A']++;
            int len = high - low + 1;
            maxFreq = Math.max(maxFreq, hash[ch - 'A']);
            int diff = len - maxFreq;

            while (diff > k) {
                //invalid part shrink the window
                char sh = s.charAt(low);

                hash[sh - 'A']--;
                low++;
                len = high - low + 1;
                maxFreq = calcFreq(hash);
                diff = len - maxFreq;
            }

            res = Math.max(res, len);
        }

        return res;
    }

    public int calcFreq(int[] hash) {
        int maxFreq = 0;

        for (int ele : hash) {
            maxFreq = Math.max(maxFreq, ele);
        }

        return maxFreq;
    }
}

Optimal : 
  class Solution {
    public int characterReplacement(String s, int k) {
        int[] hash = new int[26];
        int n = s.length();
        int maxFreq = 0;
        int low = 0;
        int res = 0;

        for (int high = 0; high < n; high++) {
            char ch = s.charAt(high);

            hash[ch - 'A']++;
            maxFreq = Math.max(maxFreq, hash[ch - 'A']);

            while ((high - low + 1) - maxFreq > k) {
                hash[s.charAt(low) - 'A']--;
                low++;
            }

            res = Math.max(res, high - low + 1);
        }

        return res;
    }
}
