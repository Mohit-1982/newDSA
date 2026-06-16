Leetcode - 3346
  Better : 
    class Solution {
    public int maxFrequency(int[] nums, int k, int numOperations) {
        int n = nums.length;
        Map<Integer, Integer> map = new HashMap<>();

        int arrSize = 0;
        
        for (int ele : nums) {
            arrSize = Math.max(ele, arrSize); 
            map.put(ele, map.getOrDefault(ele, 0) + 1);
        }

        int[] dArr = new int[arrSize + 1];

        //create difference array
        for (int i = 0; i < n; i++) {
            int l = Math.max(nums[i] - k, 0);
            int r = Math.min(nums[i] + k, arrSize);
            int x = 1;

            dArr[l]++;
            if (r + 1 < arrSize) dArr[r + 1]--;
        }

        //cumulative Sum
        int totalCount = 0;
        int result = 0;

        for (int i = 0; i <= arrSize; i++) {
            totalCount += dArr[i];

            int freq = map.getOrDefault(i, 0);
            int needConv = totalCount - freq;
            int maxPossibleOpr = Math.min(needConv, numOperations);
            result = Math.max(result, freq + maxPossibleOpr);
        }

        return result;
    }
}
    
