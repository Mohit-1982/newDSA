Leetcode - 268
  Brute : 
    class Solution {
    public int missingNumber(int[] nums) {
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            boolean found = false;
            for (int j = 0; j < n; j++) {
                if (nums[j] == i) {
                    found = true;
                    break;
                }
            }

            if (!found) return i;
        }

        return n;
    }
}

Better : 
  class Solution {
    public int missingNumber(int[] nums) {
        int i = 0;
        int n = nums.length;

        while (i < n) {
            if (nums[i] == i || nums[i] >= n) {
                i++;
            }else {//not at its correct place
                int temp = nums[i];
                nums[i] = nums[nums[i]];
                nums[temp] = temp;
            }
        }

        for (i = 0; i < n; i++) {
            if (nums[i] != i) {
                return i;
            }
        }

        return n;
    }
}

Optimal : 
  class Solution {
    public int missingNumber(int[] nums) {
        int currSum = 0;
        int n = nums.length;
        int sum = (n * (n + 1)) / 2;

        for (int i = 0; i < n; i++) {
            currSum += nums[i];
        }

        return sum - currSum;
    }
}
