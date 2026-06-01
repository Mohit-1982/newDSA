Leetcode - 523
  Optimal : 
    class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        int sum = 0;
        int res = 0;
        int n = nums.length;
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);

        for (int i = 0; i < n; i++) {
            sum += nums[i];

            if (map.containsKey(sum % k)) if (i - map.get(sum % k) >= 2) return true;
            if (!map.containsKey(sum % k)) map.put(sum % k, i);
        }

        return false;
    }
}
