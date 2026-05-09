Leetcode - 228
  Optimal : 
    class Solution {
    public List<String> summaryRanges(int[] nums) {
        int i = 0;
        int j = 1;
        int n = nums.length;
        List<String> list = new ArrayList<>();
        if (n == 0) return list;

        while (j < n) {
            if (nums[j] != nums[j - 1] + 1) {
                if (i == j - 1) list.add(String.valueOf(nums[i]));
                else list.add(nums[i] + "->" + nums[j - 1]);
                i = j;
            }
            j++;
        }

        if (i == n - 1) list.add(String.valueOf(nums[i]));
        else list.add(nums[i] + "->" + nums[j - 1]);

        return list;
    }
}
