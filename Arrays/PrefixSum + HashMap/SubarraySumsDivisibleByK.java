Leetcode - 974
  Brute : 
    class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        int res = 0;
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            int sum = 0;
            for (int j = i; j < n; j++) {
                sum += nums[j];

                if (sum % k == 0) {
                    res++;
                }
            }   
        }

        return res;
    }
}

Optimal : 
  class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        int res = 0;
        int sum = 0;
        int n = nums.length;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);

        for (int i = 0; i < n; i++) {
            sum += (nums[i]);

            int rem = sum % k;

            if (rem < 0) rem += k;
            res += map.getOrDefault(rem, 0);
            map.put(rem, map.getOrDefault(rem, 0) + 1);
        }

        return res;
    }
}
