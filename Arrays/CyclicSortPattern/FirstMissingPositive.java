Leetcode - 41
  Brute : 
    class Solution {
    public int firstMissingPositive(int[] nums) {
        boolean zero = false;
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            if (nums[i] == 0) {
                zero = true;
                break;
            }
        }

        for (int i = 1; i <= n; i++) {
            boolean isFound = false;
            for (int j = 0; j < n; j++) {
                if (nums[j] == i) {
                    isFound = true;
                    break;
                }
            }

            if (!isFound) {
                return i;
            }
        }

        return (zero) ? n : n + 1;
    }
}
Better : 
  class Solution {
    public int firstMissingPositive(int[] nums) {
        int n = nums.length;
        HashSet<Integer> set = new HashSet<>();

        for (int i = 0; i < n; i++) {
            set.add(nums[i]);
        }

        for (int i = 1; i <= n; i++) {
            if (!set.contains(i)) {
                return i;
            }
        }

        return n + 1;
    }
}
Optimal : 
  class Solution {
    public int firstMissingPositive(int[] nums) {
        int i = 0;
        int n = nums.length;
        
        while (i < n) {
            if (nums[i] == i + 1 || nums[i] > n || nums[i] <= 0 || nums[nums[i] - 1] == nums[i]) {
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
                return i + 1;
            }
        }

        return n + 1;
    }
}
