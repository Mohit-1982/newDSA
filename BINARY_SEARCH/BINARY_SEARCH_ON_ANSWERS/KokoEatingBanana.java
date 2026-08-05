Leetcode - 875
  Optimal: 
    class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        //k banana eats in one hour
        //if lesser than k banana in pile than eat them and won't eat any other in that hour
        //return k such that koko can eat all the banana in less than h hours also k should be minimum as possible

        // 3 6 7 11     h = 8
        // min = 1   max = 11
        // check --> 
        //          for k can koko eats all banana in less than h hours 
        //if yes than check for lesser k else make k bigger

        int max = 0;
        for (int ele : piles) max = Math.max(ele, max);

        int n = piles.length;
        int s = 1;
        int e = max;
        int res = -1;

        while (s <= e) {
            int m = s + (e - s) / 2;

            if (isPossible(piles, m, h)) {
                res = m;
                e = m - 1;
            } else {
                s = m + 1;
            }
        }    

        return res;    
    }

    public boolean isPossible(int[] nums, int k, int h) {
        int hour = 0;

        for (int ele : nums) {
            hour += (int) Math.ceil((double) ele / k);

            if (hour > h) return false;
        }

        return true;
    }
}
