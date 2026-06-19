Leetcode - 1094
  DAT: 
    class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
        int n = trips.length;
        int[] dArr = new int[1001];
        int m = dArr.length;

        for (int i = 0; i < n; i++) {
            int value = trips[i][0];
            int st = trips[i][1];
            int end = trips[i][2];
        
            dArr[st] += value;
            dArr[end] -= value;
        }

        for (int i = 0; i < m; i++) {
            if (i > 0) dArr[i] += dArr[i - 1];

            if (dArr[i] > capacity) return false;
        }

        return true;
    }
}

Line Sweep Algo: 
  class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
        int n = trips.length;
        TreeMap<Integer, Integer> map = new TreeMap<>();

        for (int i = 0; i < n; i++) {
            int val = trips[i][0];
            int s = trips[i][1];
            int e = trips[i][2];

            map.put(s, map.getOrDefault(s, 0) + val);
            map.put(e, map.getOrDefault(e, 0) - val);
        }

        int pass = 0;

        for (int point : map.keySet()) {
            pass += map.get(point);

            if (pass > capacity) return false;
        }

        return true;
    }
}
