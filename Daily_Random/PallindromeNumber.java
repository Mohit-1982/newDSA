Leetcode - 9
  class Solution {
    public boolean isPalindrome(int x) {
        if (x < 0) return false;
        if (x >= 0 && x <= 9) return true;

        int ori = x;
        int rev = 0;

        while (x > 0) {
            rev = rev * 10 + (x % 10);
            x /= 10;
        }

        return rev == ori;
    }
}
