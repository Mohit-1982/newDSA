Leetcode - 1854
  DAT: 
    class Solution {
    public int maximumPopulation(int[][] logs) {
        int n = logs.length;
        int[] dArr = new int[2051];

        for (int i = 0; i < n; i++) {
            int s = logs[i][0];
            int e = logs[i][1];

            dArr[s] += 1;
            dArr[e] -= 1;
        }

        int res = dArr[0];
        int resYear = 0;

        for (int i = 1; i < dArr.length; i++) {
            dArr[i] += dArr[i - 1];
            if (res < dArr[i]) {
                res = dArr[i];
                resYear = i;
            }
        }

        return resYear;
    }
}

Optimal : Line Sweep 
    
