Leetcode - 930

  Optimal : 
    class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
        int n = nums.length;
        int count = 0;
        int sum = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);

        for (int i = 0; i < n; i++) {
            sum += nums[i];

            count += map.getOrDefault(sum - goal, 0);
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }

        return count;
    }
}
