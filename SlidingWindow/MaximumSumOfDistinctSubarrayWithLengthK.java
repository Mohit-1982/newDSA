Leetcode - 2461
  Optimal:
    class Solution {
    public long maximumSubarraySum(int[] nums, int k) {
        int i = 0;
        int j = 0;

        long max = 0;
        long sum = 0;

        int n = nums.length;
        Set<Integer> set = new HashSet<>();
        Map<Integer, Integer> map = new HashMap<>();

        while (j < n) {
            int ele = nums[j];

            map.put(ele, map.getOrDefault(ele, 0) + 1);
            if (map.get(ele) > 1) set.add(ele);

            sum += ele;

            if (j - i + 1 < k) {
                j++;
            } else {
                if (set.isEmpty()) max = Math.max(max, sum);
                
                map.put(nums[i], map.get(nums[i]) - 1);

                if (map.get(nums[i]) <= 0) {
                    map.remove(nums[i]);
                }

                if (map.getOrDefault(nums[i], 0) == 1) set.remove(nums[i]);

                sum -= nums[i];

                i++;
                j++;
            }
        }

        return max;
    }
}
