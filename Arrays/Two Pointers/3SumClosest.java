Leetcode - 16
  Brute : 
    class Solution {
    public int threeSumClosest(int[] nums, int target) {
        int res = Integer.MAX_VALUE;
        int resDist = Integer.MAX_VALUE;
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                for (int k = j + 1; k < n; k++) {
                    int sum = nums[i] + nums[j] + nums[k];

                    if (Math.abs(sum - target) < resDist) {
                        res = sum;
                        resDist = Math.abs(sum - target);
                    }
                }
            }
        }

        return res;
    }
}

Optimal : 
  class Solution {
    public int threeSumClosest(int[] nums, int target) {
        int res = Integer.MAX_VALUE;
        int resDist = Integer.MAX_VALUE;
        int n = nums.length;
        Arrays.sort(nums);
        
        for (int i = 0; i < n - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue;

            int j = i + 1;
            int k = n - 1;

            while (j < k) {
                int sum = nums[i] + nums[j] + nums[k];

                if (Math.abs(sum - target) < resDist) {
                    res = sum;
                    resDist = Math.abs(sum - target);
                }

                if (sum > target) {
                    k--;
                }else if (sum < target) {
                    j++;
                }else {
                    return sum;
                }
            }
        }

        return res;
    }
}
