Leetcode - 303
  class NumArray {
    int[] arr;
    int[] prefix;

    public NumArray(int[] nums) {
        prefix = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {
            prefix[i] = (i > 0) ? prefix[i - 1] + nums[i] : nums[i];
        }    
    }
    
    public int sumRange(int left, int right) {
        int sum = (left == 0) ? prefix[right] : prefix[right] - prefix[left - 1];
        return sum;
    }
}
