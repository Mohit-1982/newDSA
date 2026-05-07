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
