Leetcode - 204
  Optimal: 
    class Solution {
    public int countPrimes(int n) {
        boolean[] sieve = new boolean[n];
        int m = sieve.length;
        Arrays.fill(sieve, true);
        
        if (m > 0) sieve[0] = false;
        if (m > 1) sieve[1] = false;

        for (int i = 2; i * i <= m; i++) {
            if (!sieve[i]) 
                continue;

            for (int j = i * i; j < m; j += i) {
                sieve[j] = false;
            }
        }

        int res = 0;

        for (int i = 2; i < m; i++) {
            if (sieve[i]) {
                res++;
            }
        }

        return res;
    }
}
