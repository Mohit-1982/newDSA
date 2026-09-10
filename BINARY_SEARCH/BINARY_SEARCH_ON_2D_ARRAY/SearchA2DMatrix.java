Leetcode - 240
  Optimal: 
    class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int n = matrix.length;
        int m = matrix[0].length;

        int row = 0;
        int col = m - 1;
//      while (row >= 0 && col >= 0 && row < n && col < m)

        while (row < n && col >= 0) {
            int ele = matrix[row][col];

            if (ele > target) {
                col--;
            } else if (ele < target) {
                row++;
            } else {
                return true;
            }
        }

        return false;
    }
}
