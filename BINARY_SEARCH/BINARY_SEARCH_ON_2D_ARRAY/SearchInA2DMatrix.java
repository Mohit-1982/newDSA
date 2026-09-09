Leetcode - 74
  Brute: 
    class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        for (int[] row : matrix) {
            for (int ele : row) {
                if (ele == target) {
                    return true;
                }
            }
        }

        return false;
    }
}

Better:
  class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        for (int[] row : matrix) {
            int s = 0;
            int e = row.length - 1;

            while (s <= e) {
                int m = s + (e - s) / 2;

                if (row[m] == target) return true;
                else if (row[m] > target) e = m - 1;
                else s = m + 1;
            }
        }

        return false;
    }
}

Optimal: 
  class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int n = matrix.length;
        int m = matrix[0].length;

        int s = 0;
        int e = (n * m) - 1;

        while (s <= e) {
            int mid = s + (e - s) / 2;

            int row = mid / m;
            int col = mid % m;

            int ele = matrix[row][col];

            if (ele == target) return true;
            else if (ele > target) e = mid - 1;
            else s = mid + 1;
        }

        return false;
    }
}
