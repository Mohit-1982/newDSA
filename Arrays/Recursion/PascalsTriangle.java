Leetcode - 118
  Brute : 
    class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>();

        gen(res, numRows);
        return res;
    }

    public void gen(List<List<Integer>> res, int n) {
        if (n == 1) {
            List<Integer> list = new ArrayList<>();
            list.add(1);
            res.add(list);
            return;
        }

        gen(res, n - 1);

        List<Integer> list = res.get(res.size() - 1);
        List<Integer> ls = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int above = (i < list.size()) ? list.get(i) : 0;
            int aboveLeft = (i - 1 >= 0) ? list.get(i - 1) : 0;

            ls.add(above + aboveLeft); 
        }

        res.add(ls);
    }
}

Optimal : 
  class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>();

        for (int i = 1; i <= numRows; i++) {
            List<Integer> list = new ArrayList<>();

            for (int j = 0; j < i; j++) {
                if (j == 0 || j == i - 1) list.add(1);
                else {
                    int above = res.get(res.size() - 1).get(j);
                    int aboveLeft = res.get(res.size() - 1).get(j - 1);

                    list.add(above + aboveLeft);
                }
            }

            res.add(list);
        }

        return res;
    }
}
