Leetcode - 904
  Optimal : 
    class Solution {
    public int totalFruit(int[] fruits) {
        int low = 0;
        int res = 0;
        int n = fruits.length;
        Map<Integer, Integer> map = new HashMap<>();

        for (int high = 0; high < n; high++) {
            map.put(fruits[high], map.getOrDefault(fruits[high], 0) + 1);

            while (map.size() > 2) {
                int ele = fruits[low];

                if (map.get(ele) <= 1) map.remove(ele);
                else map.put(ele, map.get(ele) - 1);
                low++;
            }

            if (map.size() <= 2) res = Math.max(res, high - low + 1);
        }

        return res;
    }
}
