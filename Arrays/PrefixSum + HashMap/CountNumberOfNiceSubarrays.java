Leetcode - 1248
  Optimal :   
    class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        int n = nums.length;
        int odd = 0;
        int res = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);

        for (int i = 0; i < n; i++) {
            if (nums[i] % 2 == 1) {
                odd++;
            }

            res += map.getOrDefault(odd - k, 0);
            map.put(odd, map.getOrDefault(odd, 0) + 1);
        }

        return res;
    }
}
