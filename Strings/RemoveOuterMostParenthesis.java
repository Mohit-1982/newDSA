Leetcode - 1021
  Optimal:
    class Solution {
    public String removeOuterParentheses(String s) {
        int i = 0;
        int j = 0;
        int leftCount = 0;
        int rightCount = 0;
        int n = s.length();
        StringBuilder sb = new StringBuilder();

        while (i < n) {
            char ch = s.charAt(i);

            if (ch == '(') leftCount++;
            else rightCount++;

            if (leftCount == rightCount) {
                sb.append(s.substring(j + 1, i));
                j = i + 1;
            }

            i++;
        }

        return sb.toString();
    }
}
