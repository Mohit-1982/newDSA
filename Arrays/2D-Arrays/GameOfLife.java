Leetcode - 289

  Brute : 
    class Solution {
    public void gameOfLife(int[][] board) {
        int n = board.length;
        int m = board[0].length;
        int[][] copy = new int[n][m];

        //avoid extra matrix by marking them with 2 and -1 for state changing

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                copy[i][j] = board[i][j];
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int ele = copy[i][j];
                int count = giveCount(copy, i, j);

                if (count < 2 && ele == 1)
                    board[i][j] = 0;
                else if (ele == 1 && count > 3)
                    board[i][j] = 0;
                else if (ele == 0 && count == 3)
                    board[i][j] = 1;
            }
        }
    }

    public int giveCount(int[][] copy, int row, int col) {
        int count = 0;
        int n = copy.length;
        int m = copy[0].length;

        int[] dirRow = { -1, -1, -1, 0, +1, +1, +1, 0 };
        int[] dirCol = { -1, 0, +1, +1, +1, 0, -1, -1 };

        for (int i = 0; i < dirRow.length; i++) {
            int drow = dirRow[i];
            int dcol = dirCol[i];

            int calcRow = row + drow;
            int calcCol = col + dcol;

            if (calcRow < 0 || calcCol < 0 || calcRow >= n || calcCol >= m)
                continue;

            count += (copy[calcRow][calcCol] == 1) ? 1 : 0;
        }

        return count;
    }
}
