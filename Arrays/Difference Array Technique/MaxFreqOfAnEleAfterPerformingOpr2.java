Leetcode - 3347
  Optimal : 
    class Solution {
    public int maxFrequency(int[] nums, int k, int numOperations) {
        int n = nums.length;
        Map<Integer, Integer> map = new TreeMap<>();
        Map<Integer, Integer> freqMap = new HashMap<>();


        int maxValue = 0;
        for (int ele : nums) {
            maxValue = Math.max(ele, maxValue);
            map.put(ele, 0);
            freqMap.put(ele, freqMap.getOrDefault(ele, 0) + 1);
        }

        //create difference map 
        for (int ele : nums) {
            int l = Math.max(0, ele - k);
            int r = Math.min(maxValue, ele + k);
            
            map.put(l, map.getOrDefault(l, 0) + 1);
            map.put(r + 1, map.getOrDefault(r + 1, 0) - 1);
        }

        //cumulative sum
        int totalCount = 0;
        int result = 0;

        for (int ele : map.keySet()) {
            totalCount += map.get(ele);

            int freq = freqMap.getOrDefault(ele, 0);
            int needConv = totalCount - freq;
            int maxPossibleOpr = Math.min(numOperations, needConv);
            result = Math.max(result, freq + maxPossibleOpr);
        }

        return result;
    }
}
