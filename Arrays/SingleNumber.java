Leetcode - 136
  Brute : 
    class Solution {
    public int singleNumber(int[] nums) {
       int n = nums.length;

       for (int i = 0; i < n; i++) {
        boolean find = false;
            for (int j = 0; j < n; j++) {
                if (i != j && nums[i] == nums[j]) {
                    find = true;
                    break;
                }
            }

            if (!find) return nums[i];
       }

       return -1;
    }
}

Better : 
  class Solution {
    public int singleNumber(int[] nums) {
       int n = nums.length;
       HashMap<Integer, Integer> map = new HashMap<>();

       for (int ele : nums) {
            map.put(ele, map.getOrDefault(ele, 0) + 1);
       }

       for (int ele : map.keySet()) {
            if (map.get(ele) == 1) {
                return ele;
            }
       }

       return -1;
    }
}

Optimal : 
  class Solution {
    public int singleNumber(int[] nums) {
        int xor = 0;
        int n = nums.length;
       
        for (int ele : nums) {
            xor ^= ele;
        }

       return xor;
    }
}
