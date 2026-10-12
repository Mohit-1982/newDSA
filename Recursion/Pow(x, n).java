Leetcode - 50 
  Optimal:
    class Solution {
    public double myPow(double x, int n) {
        boolean isNeg = (n < 0) ? true : false;
        
        if (isNeg) n *= -1;

        double res = findPow(x, n);

        if (isNeg) return 1 / res;
        return res;
    }
    public double findPow(double x, int n) {
        if (n == 0) return 1;
        if (n == 1) return x;

        double half = findPow(x, n / 2);

        if (n % 2 == 0) {
            return half * half;
        }

        return half * half * x;
    }
}
