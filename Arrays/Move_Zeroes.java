Leetcode - 283
  Brute : 
    class Solution {
    public void moveZeroes(int[] nums) {
        int n = nums.length;

        outer : for (int i = 0; i < n; i++) {
            boolean swap = false;
            inner : for (int j = 0; j < n - i - 1; j++) {
                if (nums[j] == 0) {
                    int temp = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = temp;
                    swap = true;
                }
            }

            if (!swap) {
                break outer;
            }
        }
    }
}
Better :     
  class Solution {
    public void moveZeroes(int[] nums) {
        int k = 0;
        int n = nums.length;
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            if (nums[i] != 0) {
                arr[k++] = nums[i];
            }
        }

        for (int j = 0; j < n; j++) {
            nums[j] = arr[j];
        }
    }
}

sligtly overcomplicated : 
  class Solution {
    public void moveZeroes(int[] nums) {
        int i = 0;
        int j = 0;
        int n = nums.length;

        while (i < n && j < n) {
            while (i < n && nums[i] != 0) {
                i++;
            }
            if (i < j && nums[j] != 0) {
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
            }
            j++;
        }
    }
}

Optimal :   
  class Solution {
    public void moveZeroes(int[] nums) {
        int i = 0;
        int n = nums.length;

        for (int j = 0; j < n; j++) {
            if (nums[j] != 0) {
                int temp = nums[j];
                nums[j] = nums[i];
                nums[i] = temp;
                i++;
            }
        }
    }
}
