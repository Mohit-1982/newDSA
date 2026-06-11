Leetcode - 128
  Brute : 
    class Solution {
    public int longestConsecutive(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        int len = 0;
        int i = 0;
        
        while (i < n) {
            int currLen = 0;

            while (i < n - 1 && ((nums[i] == nums[i + 1]) || (nums[i] == nums[i + 1] - 1))) {
                if (nums[i] != nums[i + 1]) currLen++;
                i++;
            }

            len = Math.max(currLen + 1, len);
            i++;
        }

        return len;
    }
}

Optimal : 
  class Solution {
    public int longestConsecutive(int[] nums) {
        int len = 0;
        int n = nums.length;
        HashSet<Integer> set = new HashSet<>();

        for (int ele : nums) set.add(ele);

        for (int ele : set) {
            if (set.contains(ele - 1)) continue;

            int currLen = 0;
            int newEle = ele;

            while (set.contains(newEle)) {
                currLen++;
                newEle++;
            }

            len = Math.max(len, currLen);
        }

        return len;
    }
}
