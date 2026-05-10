Leetcode - 485
  Brute : 
    class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int n = nums.length;
        int maxOne = 0;

        for (int i = 0; i < n; i++) {
            if (nums[i] != 1) continue;
            int max = 0;
            for (int j = i; j < n; j++) {
                if (nums[j] != 1) {
                    break;
                }
                max++;
            }

            maxOne = Math.max(maxOne, max);
        }

        return maxOne;
    }
}

Optimal but overcomplicated :   
  class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int i = 0;
        int maxOne = 0;
        int n = nums.length;

        while (i < n) {
            if (nums[i] == 1) {
                int j = i;
                while (j < n && nums[j] == 1) {
                    j++;
                }
                maxOne = Math.max(maxOne, j - i);
                i = j;
            }
            i++;
        }

        return maxOne;
    }
}

Optimal : 
  class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int count = 0;
        int maxOne = 0;
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            if (nums[i] == 1) {
                count++;
                maxOne = Math.max(maxOne, count);
            }else {
                count = 0;
            }
        }

        return maxOne;
    }
}
