Leetcode - 153
  Brute : 
    class Solution {
    public int findMin(int[] nums) {
        //do it with O(logn)
        int min = Integer.MAX_VALUE;

        for (int ele : nums) {
            min = Math.min(min, ele);
        }

        return min;
    }
}
