Leetcode - 125
  Optimal : 
    class Solution {
    public boolean isPalindrome(String s) {
        int n = s.length();
        int i = 0;
        int j = n - 1;

        while (i < j) {
            char ch = s.charAt(i);
            char bh = s.charAt(j);
            if (!isAlNum(ch)) {
                i++;
                continue;
            }
            if (!isAlNum(bh)) {
                j--;
                continue;
            }
            if (isAlNum(ch) && isAlNum(bh)) {
                if (Character.toLowerCase(ch) != Character.toLowerCase(bh)) {
                    return false;
                }
                i++;
                j--;
            }
        }
        
        return true;
    }

    public boolean isAlNum(char ch) {
        if ((ch >= 'a' && ch <= 'z') || (ch >= 'A' && ch <= 'Z') || (ch >= '0' && ch <= '9')) return true;
        return false;
    }
}
