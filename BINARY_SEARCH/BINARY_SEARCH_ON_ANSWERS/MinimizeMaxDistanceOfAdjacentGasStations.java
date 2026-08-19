GFG
  Optimal: 
    class Solution {
    public double minMaxDist(int[] stations, int k) {
        if (stations.length <= 1) return 0;
        
        double s = 0;
        double e = findEnd(stations);
        
        while (e - s > 1e-6) {
            double mid = s + (e - s) / 2;
            
            if (isPossible(stations, k, mid)) {
                e = mid;
            } else {
                s = mid;
            }
        }
        
        return e;
    }
    
    public boolean isPossible(int[] sta, int pump, double gapAllowed) {
        int n = sta.length;
        int pumpInserted = 0;
        
        for (int i = 1; i < n; i++) {
            int gap = sta[i] - sta[i - 1];
            
            if (gap > gapAllowed) {
                int pumpToPut = (int) Math.ceil(gap / gapAllowed) - 1;
                pumpInserted += pumpToPut;
                
                if (pumpInserted > pump) {
                    return false;
                }
            }
        }
        
        return true;
    }
    
    public double findEnd(int[] sta) {
        int consMax = -1;
        
        for (int i = 1; i < sta.length; i++) {
            consMax = Math.max(consMax, sta[i] - sta[i - 1]);
        }
        
        return consMax;
    }
}
