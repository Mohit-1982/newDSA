Leetcode - 152
  Optimal : 
    class Solution {
    public int maxProduct(int[] nums) {
        int n = nums.length;
        int prd = nums[0];
        int maxPrd = nums[0];
        int minPrd = nums[0];
        
        for (int i = 1; i < n; i++) {
            int dont = nums[i];
            int maxE = nums[i] * maxPrd;
            int minE = nums[i] * minPrd;

            maxPrd = Math.max(maxE, Math.max(dont, minE));
            minPrd = Math.min(maxE, Math.min(dont, minE));
            prd = Math.max(prd, Math.max(minPrd, maxPrd));
        }

        return prd;
    }
}
