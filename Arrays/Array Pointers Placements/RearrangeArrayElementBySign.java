Leetcode - 2149
  Optimal : 
    class Solution {
    public int[] rearrangeArray(int[] nums) {
        int pos = 0;
        int neg = 1;
        int n = nums.length;
        int[] res = new int[n];

        for (int ele : nums) {
            if (ele > 0) {
                res[pos] = ele;
                pos += 2;
            }else {
                res[neg] = ele;
                neg += 2;
            }
        }

        return res;
    }
}
