Leetcode - 48
  Brute : 
    class Solution {
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        int[][] res = new int[n][m];

        for (int col = 0; col < m; col++) {
            for (int row = 0; row < n; row++) {
                res[col][row] = matrix[row][col];
            } 
        }

        for (int i = 0; i < n; i++) {
            reverse(res, i);
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                matrix[i][j] = res[i][j];
            }
        }
    }

    public void reverse(int[][] matrix, int row) {

        int i = 0; 
        int j = matrix[0].length - 1;

        while (i < j) {
            int temp = matrix[row][i];
            matrix[row][i] = matrix[row][j];
            matrix[row][j] = temp;
            i++;
            j--;
        }
    }
}

Optimal : 
  class Solution {
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;

        for (int i = 0; i < n; i++) {
            for (int j = i; j < m; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

        for (int i = 0; i < n; i++) {
            reverse(matrix, i);
        }
    }

    public void reverse(int[][] matrix, int row) {

        int i = 0; 
        int j = matrix[0].length - 1;

        while (i < j) {
            int temp = matrix[row][i];
            matrix[row][i] = matrix[row][j];
            matrix[row][j] = temp;
            i++;
            j--;
        }
    }
}
