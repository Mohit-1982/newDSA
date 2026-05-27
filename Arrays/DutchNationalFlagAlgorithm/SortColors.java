Leetcode - 75
  class Solution {
    public void sortColors(int[] nums) {
        int l = 0;
        int m = 0;
        int h = nums.length - 1;
        
        while (m <= h) {
            if (nums[m] == 0) {
                int temp = nums[m];
                nums[m] = nums[l];
                nums[l] = temp;

                m++;
                l++;
            }else if (nums[m] == 1) {
                m++;
            }else {
                int temp = nums[m];
                nums[m] = nums[h];
                nums[h] = temp;

                h--;
            }
        }
    }
}
