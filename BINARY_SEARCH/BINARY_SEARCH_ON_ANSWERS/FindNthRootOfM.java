GFG
  Optimal: TC --> O(logn * logm)
           SC --> O(logn)
    class Solution {
    public int nthRoot(int n, int m) {
        int s = 0;
        int e = m;
        
        while (s <= e) {
            int mid = s + (e - s) / 2;
            int power = power(mid, n);
            
            if (power == m) return mid;
            else if (power > m) e = mid - 1;
            else s = mid + 1;
        }
        
        return -1;
    }
    
    public int power(int a, int b) {
        if (b == 0) return 1;
        if (b == 1) return a;
        
        int half = power(a, b / 2);
        
        int pow = half * half;
        if (b % 2 != 0) pow *= a;
        
        return pow;
    }
}
