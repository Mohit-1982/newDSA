Leetcode - 3517
  Optimal: 
    class Solution {
    public String smallestPalindrome(String s) {
        int n = s.length();

        if (n == 1) return s;

        //babab
        //sort --> aabbb
        //pallindromic --> abbba

        //daccad
        //sort --> aaccdd
        //pallindromic --> acddca

        //aabbccd
        //sort --> aabbccd
        //pallindromic --> abcdcba

        //raceecar
        //sort --> aacceerr
        //pallindromic --> acerreca

        int[] cr = new int[26];

        for (int i = 0; i < n; i++) {
            cr[s.charAt(i) - 'a']++;
        }

        StringBuilder sb = new StringBuilder();
        Character odd = null;

        for (int i = 0; i < cr.length; i++) {
            if (cr[i] > 0) {
                int loopTill = cr[i];
                char ch = (char) (97 + i);

                if (loopTill % 2 == 1) odd = ch;

                for (int j = 0; j < loopTill / 2; j++) {
                    sb.append(ch);
                }
            }
        }

        String str = sb.reverse().toString();
        sb.reverse();
        if (odd != null) sb.append(odd);
        sb.append(str);

        return sb.toString();
    }
}
