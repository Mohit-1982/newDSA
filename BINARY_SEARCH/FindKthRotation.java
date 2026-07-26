GFG
  Optimal : 
    class Solution {
    public int findKRotation(int arr[]) {
        int idx = findMinIdx(arr);
        
        return idx;
    }
    public int findMinIdx(int[] nums) {
        int s = 0;
        int e = nums.length - 1;
        int res = Integer.MAX_VALUE;
        int resIdx = -1;

        while (s <= e) {
            int m = s + (e - s) / 2;

            if (nums[m] < res) {
                res = nums[m];
                resIdx = m;
            }

            if (nums[m] > nums[e]) s = m + 1;
            else e = m - 1;
        }

        return resIdx;
    }
}
