GFG
  Optimal : 
    class Solution {
    public ArrayList<Integer> sieve(int n) {
        boolean[] isPrime = new boolean[n + 1];
        Arrays.fill(isPrime, true);
        isPrime[0] = false;
        isPrime[1] = false;
        
        for (int i = 2; i * i <= n; i++) {
            if (isPrime[i]) {
                for (int j = i * 2; j <= n; j += i) {
                    isPrime[j] = false;
                }
            }
        }
        
        ArrayList<Integer> res = new ArrayList<>();
        
        for (int i = 0; i <= n; i++) {
            if (isPrime[i]) {
                res.add(i);
            }    
        }
        
        return res;
    }
}
