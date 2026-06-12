Leetcode - 54
  Optimal : 
    class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;

        int fr = 0;
        int lr = n - 1;
        int fc = 0;
        int lc = m - 1;
        List<Integer> res = new ArrayList<>();

        while (fr <= lr && fc <= lc) {

            for (int i = fc; i <= lc; i++) {
                res.add(matrix[fr][i]);
            }
            fr++;

            for (int i = fr; i <= lr; i++) {
                res.add(matrix[i][lc]);
            }
            lc--;

            if (fr <= lr) {
                for (int i = lc; i >= fc; i--) {
                    res.add(matrix[lr][i]);
                }
                lr--;
            }

            if (fc <= lc) {
                for (int i = lr; i >= fr; i--) {
                    res.add(matrix[i][fc]);
                }
                fc++;
            }
        }

        return res;
    }
}
