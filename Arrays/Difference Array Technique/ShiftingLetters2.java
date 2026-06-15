Leetcode - 2381
  Optimal :   
    class Solution {
    public String shiftingLetters(String str, int[][] shifts) {
        int n = str.length();
        int[] dArr = new int[n];

        for (int i = 0; i < shifts.length; i++) {
            int s = shifts[i][0];
            int e = shifts[i][1];
            int d = shifts[i][2];
            int x = (d == 0) ? -1 : 1;

            dArr[s] += x;
            if (e + 1 < n) dArr[e + 1] -= x;
        }

        int sum = 0;
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < n; i++) {
            sum += dArr[i];

            char ch = str.charAt(i);
            int shifted = ((ch - 'a') + sum) % 26;
            if (shifted < 0) shifted += 26;

            sb.append((char) ('a' + shifted));
        }

        return sb.toString();
    }
}
