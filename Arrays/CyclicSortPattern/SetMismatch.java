Leetcode - 645
  class Solution {
    public int[] findErrorNums(int[] nums) {
        //we can create a seen array in which we don't mark the duplicate
        //and apart from it we will mark everyone
        int i = 0;
        int n = nums.length;

        while (i < n) {
            if (nums[i] == i + 1 || nums[nums[i] - 1] == nums[i] || nums[i] > n) {
                i++;
            }else {
                int cIdx = nums[i] - 1;

                int temp = nums[i];
                nums[i] = nums[cIdx];
                nums[cIdx] = temp;
            }
        }

        for (i = 0; i < n; i++) {
            if (nums[i] != i + 1) {
                int[] arr = new int[2];
                arr[0] = nums[i];
                arr[1] = i + 1;
                return arr;
            }
        }

        int[] arr = new int[2];
        arr[0] = -1;
        arr[1] = -1;
        return arr;
    }
}
