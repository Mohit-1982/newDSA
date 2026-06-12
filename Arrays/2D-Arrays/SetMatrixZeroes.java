Leetcode - 73
  Better : 
    class Solution {
    public void setZeroes(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        int[] row = new int[n];
        int[] col = new int[m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (matrix[i][j] == 0) {
                    row[i]++;
                    col[j]++;
                }
            }
        }

        for (int i = 0; i < n; i++) {
            if (row[i] > 0) {
                fillRowZero(matrix, i);
            }
        }

        for (int j = 0; j < m; j++) {
            if (col[j] > 0) {
                fillColZero(matrix, j);
            }
        }
    }

    public void fillRowZero(int[][] arr, int row) {
        for (int i = 0; i < arr[0].length; i++) {
            arr[row][i] = 0;
        }
    }

    
    public void fillColZero(int[][] arr, int col) {
        for (int i = 0; i < arr.length; i++) {
            arr[i][col] = 0;
        }
    }
}

Optimal : 
  class Solution {
    public void setZeroes(int[][] matrix) {
        int col0 = 1;
        int n = matrix.length;
        int m = matrix[0].length;
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    if (j != 0) matrix[0][j] = 0;
                    else col0 = 0;
                }
            }
        }

        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                if (matrix[0][j] == 0 || matrix[i][0] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }

        if (matrix[0][0] == 0) {
            for (int i = 0; i < m; i++) {
                matrix[0][i] = 0;
            }
        }

        if (col0 == 0) {
            for (int j = 0; j < n; j++) {
                matrix[j][0] = 0;
            }
        }
    }
}
