Leetcode - 560
  Brute : 
    class Solution {
    public int subarraySum(int[] nums, int k) {
        int res = 0;
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            int sum = 0;
            for (int j = i; j < n; j++) {
                sum += nums[j];
                if (sum == k) {
                    res++;
                }
            }
        }

        return res;
    }
}

Optimal : 
  class Solution {
    public int subarraySum(int[] nums, int k) {
        int res = 0;
        int sum = 0;
        int n = nums.length;
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        
        for (int i = 0; i < n; i++) {
            sum += nums[i];
            
            res += map.getOrDefault(sum - k, 0);
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }

        return res;
    }
}
