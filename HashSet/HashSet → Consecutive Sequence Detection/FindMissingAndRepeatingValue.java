Leetcode - 2965
  Brute: 
    class Solution {
    public int[] findMissingAndRepeatedValues(int[][] grid) {
        int dup = -1;
        int miss = -1;
        int n = grid.length;
        int m = grid[0].length;
        Set<Integer> set = new HashSet<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (set.contains(grid[i][j]))
                    dup = grid[i][j];
                set.add(grid[i][j]);
            }
        }

        int count = 1;
        for (int i = 0; i < set.size(); i++) {
            if (set.contains(count))
                count++;
            else {
                miss = count;
                break;
            }
        }

        if (miss == -1)
            miss = count;

        return new int[] { dup, miss };
    }
}
