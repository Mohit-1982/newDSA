GFG
  Optimal : 
    class Solution {
    int countFreq(int[] arr, int target) {
        //find first and last occu then sub them we will get
        //number of occurance of that element
        int[] res = searchRange(arr, target);
        return (res[0] == -1) ? 0 : res[1] - res[0] + 1;
    }
    public int[] searchRange(int[] nums, int target) {
        int s = 0;
        int e = nums.length - 1;
        int[] res = new int[]{-1, -1};

        while (s <= e) {
            int m = s + (e - s) / 2;

            if (nums[m] < target) s = m + 1;
            else e = m - 1; 
        }

        if (s >= nums.length || nums[s] != target) return res;
        res[0] = s;

        s = 0;
        e = nums.length - 1;

        while (s <= e) {
            int m = s + (e - s) / 2;

            if (nums[m] <= target) s = m + 1;
            else e = m - 1;
        }

        res[1] = e;

        return res;
    }
}
