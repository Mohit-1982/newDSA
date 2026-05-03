class Solution {
    public int sumOfPrimesInRange(int n) {
        //use sieve of eratoshthanes
        int sum = 0;
        int r = rev(n);
        int s = Math.min(n, r);
        int e = Math.max(n, r);

        for (int i = s; i <= e; i++) {
            if (isPrime(i)) {
                sum += i;
            }
        }

        return sum;
    }
    public boolean isPrime(int num) {
        if (num <= 1) return false;
        if (num == 2) return true;
        if (num % 2 == 0) return false;//eliminated all even


        for (int i = 3; i * i <= num; i++) {
            if (num % i == 0) {
                return false;
            }
        }

        return true;
    }
    public int rev(int n) {
        int rev = 0;
        while (n > 0) {
            rev = rev * 10 + (n % 10);
            n /= 10;
        }

        return rev;
    }
}©leetcode
