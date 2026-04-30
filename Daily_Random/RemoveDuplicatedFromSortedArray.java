Leetcode - 26
  Brute : 
    class Solution {
    public int removeDuplicates(int[] nums) {
        int n = nums.length;
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            if (list.isEmpty()) {
                list.add(nums[i]);
            }else {
                if (list.get(list.size() - 1) != nums[i]) {
                    list.add(nums[i]);
                }
            }
        }

        for (int i = 0; i < list.size(); i++) {
            nums[i] = list.get(i);
        }

        return list.size();
    }
}

  Optimal : 
    class Solution {
    public int removeDuplicates(int[] nums) {
        int i = 0;
        int n = nums.length;

        for (int j = 0; j < n; j++) {
            if (nums[j] != nums[i]) {
                nums[++i] = nums[j];
            }
        }

        return i + 1;
    }
}
