Leetcode - 448
  Brute : 
    class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        int n = nums.length;
        HashSet<Integer> set = new HashSet<>();
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            set.add(nums[i]);
        }

        for (int i = 1; i <= n; i++) {
            if (!set.contains(i)) {
                list.add(i);
            }
        }

        return list;
    }
}
Optimal : 
  class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        int i = 0;
        int n = nums.length;
        List<Integer> list = new ArrayList<>();

        while (i < n) {
            if (nums[i] == i + 1 || nums[nums[i] - 1] == nums[i]) {
                i++;
            }else {
                int correctIdx = nums[i] - 1;

                int temp = nums[i];
                nums[i] = nums[correctIdx];
                nums[correctIdx] = temp;
            }
        }

        for (i = 0; i < n; i++) {
            if (nums[i] != i + 1) {
                list.add(i + 1);
            }
        }

        return list;
    }
}
