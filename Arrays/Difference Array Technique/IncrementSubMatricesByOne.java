Leetcode - 2536
  Brute : 
    class Solution {
    public int[][] rangeAddQueries(int n, int[][] queries) {
        int[][] res = new int[n][n];
        int m = queries.length;

        for (int i = 0; i < m; i++) {
            int row1 = queries[i][0];
            int col1 = queries[i][1];
            int row2 = queries[i][2];
            int col2 = queries[i][3];

            for (int j = row1; j <= row2; j++) {
                for (int k = col1; k <= col2; k++) {
                    res[j][k]++;
                }
            }
        }

        return res;
    }
}

Better : 
  class Solution {
    public int[][] rangeAddQueries(int n, int[][] queries) {
        int[][] res = new int[n][n];
        int m = queries.length;

        for (int i = 0; i < m; i++) {
            int row1 = queries[i][0];
            int col1 = queries[i][1];
            int row2 = queries[i][2];
            int col2 = queries[i][3];

            for (int j = row1; j <= row2; j++) {
                res[j][col1] += 1;
                if (col2 + 1 < n) res[j][col2 + 1] -= 1;
            }
        }

        for (int i = 0; i < n; i++) {
            int sum = 0;

            for (int j = 0; j < n; j++) {
                sum += res[i][j];
                res[i][j] = sum;
            }
        }

        return res;
    }
}
