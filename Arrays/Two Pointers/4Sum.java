Leetcode - 18
  Optimal : 
    class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        int n = nums.length;
        List<List<Integer>> res = new ArrayList<>();
        
        for (int i = 0; i < n - 3; i++) {
            if (i != 0 && nums[i] == nums[i - 1]) continue;

            for (int j = i + 1; j < n - 2; j++) {
                if (j != i + 1 && nums[j] == nums[j - 1]) continue;

                int k = j + 1;
                int l = n - 1;

                while (k < l) {
                    long sum = (long) nums[i] + nums[j] + nums[k] + nums[l];

                    if (sum > (long) target) l--;
                    else if (sum < (long) target) k++;
                    else {
                        List<Integer> ls = new ArrayList<>();
                        ls.add(nums[i]);
                        ls.add(nums[j]);
                        ls.add(nums[k]);
                        ls.add(nums[l]);

                        res.add(ls);

                        k++;
                        l--;

                        while (k < l && nums[k] == nums[k - 1]) k++;
                        while (l > k && nums[l] == nums[l + 1]) l--;
                    }
                }
            }
        }

        return res;
    }
}
