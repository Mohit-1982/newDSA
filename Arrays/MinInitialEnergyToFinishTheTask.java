Leetcode - 1665
  Better :   
    class Solution {
    public int minimumEffort(int[][] tasks) {
        //Greedy Idea -> Do the most demanding tasks first.
        //(minimum - actual) is larger
        int res = 0;
        int minEnr = 0;
        int maxEnr = 0;
        int n = tasks.length;
        int l = tasks[0].length;

        //Apply sorting as well
        Arrays.sort(tasks, (a, b) -> Integer.compare(
    (b[1] - b[0]),
    (a[1] - a[0])
));

//we have sorted it with diff of min eng required with eng going to take 

        for (int i = 0; i < n; i++) {
            maxEnr += tasks[i][1];
        }

        while (minEnr <= maxEnr) {
            int m = minEnr + (maxEnr - minEnr) / 2;

            if (check(tasks, m)) {
                res = m;
                maxEnr = m - 1;
            }else {
                minEnr = m + 1;
            }
        }

        return res;
    }

    public boolean check(int[][] tasks, int enr) {
        int n = tasks.length;
        int m = tasks[0].length;

        for (int i = 0; i < n; i++) {
            if (enr < tasks[i][1]) {
                return false;
            }
            enr -= tasks[i][0];
        }

        return true;
    }
}
