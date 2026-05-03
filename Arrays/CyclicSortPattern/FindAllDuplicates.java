Brute : 
  class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        int n = nums.length;
        List<Integer> res = new ArrayList<>();
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }

        for (int ele : map.keySet()) {
            if (map.get(ele) == 2) {
                res.add(ele);
            }
        }

        return res;
    }
}
Optimal : 
  class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        int i = 0;
        int n = nums.length;
        List<Integer> res = new ArrayList<>();
        
        while (i < n) {
            if (nums[nums[i] - 1] == nums[i] || nums[i] == i + 1) {
                i++;
            }else {
                int correct = nums[i] - 1;

                int temp = nums[i];
                nums[i] = nums[correct];
                nums[correct] = temp;
            }
        }

        for (i = 0; i < n; i++) {
            if (nums[i] != i + 1) {
                res.add(nums[i]);
            }
        }

        return res;
    }
}
