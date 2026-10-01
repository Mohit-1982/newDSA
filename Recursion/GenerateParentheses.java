Leetcode - 22

  class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList<>();

        genCombinations(0, 0, n, new StringBuilder(), list);
        return list;
    }

    public void genCombinations(int l, int r, int n, StringBuilder str, List<String> list) {
        if (l + r == 2 * n) {
            list.add(str.toString());
            return;
        }

        if (l < n) {
            str.append("(");
            genCombinations(l + 1, r, n, str, list);
            str.deleteCharAt(str.length() - 1);
        }

        if (r < l) {
            str.append(")");
            genCombinations(l, r + 1, n,str , list);
            str.deleteCharAt(str.length() - 1);
        }
    }
}
