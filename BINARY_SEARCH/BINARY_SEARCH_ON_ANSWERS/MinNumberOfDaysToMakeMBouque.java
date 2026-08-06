Leetcode - 1482
  TC --> O(n * log(maxEleInBloomDay))
  SC --> O(1)
    Optimal :
      class Solution {
    public int minDays(int[] bloomDay, int m, int k) {
        if ((long) m * k >  bloomDay.length) return -1;
        int max = -1;

        for (int ele : bloomDay) max = Math.max(ele, max);

        int n = bloomDay.length;
        int s = 1;
        int e = max;
        int res = -1;

        while (s <= e) {
            int mid = s + (e - s) / 2;

            if (isPossible(bloomDay, mid, k, m)) {
                res = mid;
                e = mid - 1;
            } else {
                s = mid + 1;
            }
        }

        return res;
    }

    public boolean isPossible(int[] bloomDay, int days, int flowers, int bouqe) {
        int count = 0;
        int compBouque = 0;

        for (int ele : bloomDay) {
            if (ele > days) count = 0;
            else count++;

            if (count == flowers) {
                count = 0;
                compBouque++;

                if (compBouque >= bouqe) return true;
            }
        }

        return false;
    }
}
