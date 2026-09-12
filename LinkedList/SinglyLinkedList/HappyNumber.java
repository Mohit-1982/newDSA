Leetcode - 202
  Brute:
    class Solution {
    public boolean isHappy(int n) {
        Set<Integer> set = new HashSet<>();
        set.add(n);

        while (n != 1) {
            int calc = calcNum(n);

            if (set.contains(calc)) return false;

            if (calc == 1) return true;

            set.add(calc);
            n = calc;
        }

        return true;
    }

    public int calcNum(int n) {
        int res = 0;

        while (n > 0) {
            res += (n % 10) * (n % 10);
            n /= 10;
        }

        return res;
    }
}

Optimal:
  class Solution {
    public boolean isHappy(int n) {
        int slow = -1;
        int fast = n;

        while (n != 1) {
            slow = calc(n);
            fast = calc(calc(fast));
            
            if (slow == 1 || fast == 1) return true;
            if (slow == fast) return false;

            n = slow;
        }

        return true;
    }

    public int calc(int n) {
        int res = 0;

        while (n > 0) {
            res += (n % 10) * (n % 10);
            n /= 10;
        }

        return res;
    }
}
