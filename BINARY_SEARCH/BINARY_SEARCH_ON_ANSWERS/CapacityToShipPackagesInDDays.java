Leetcode - 1011
  Optimal : 
    class Solution {
    public int shipWithinDays(int[] weights, int days) {
        //TC --> O(n * log(sum of weigths))
        //SC --> O(1)

        int sum = 0;
        for (int ele : weights)
            sum += ele;

            

        int s = 1;
        //here, we can use starting index as max ele of this weight array becasue if ele is smaller than max ele of this weight array i won't be able to hold that weight because we can not split the weight into two this will reduce the time comp to O(n * log(sum - max)) as well as it removes the check if (ele > cap) return false in isPossible() Funciton
        int e = sum;
        int res = -1;

        while (s <= e) {
            int m = s + (e - s) / 2;
            //m is the capacity of ship here

            if (isPossible(weights, days, m)) {
                res = m;
                e = m - 1;
            } else {
                s = m + 1;
            }
        }

        return res;
    }

    public boolean isPossible(int[] nums, int days, int cap) {
        int currDay = 1;//because, we are going to take the packages at first day not zero 
        int onGoingCap = 0;

        for (int ele : nums) {
            onGoingCap += ele;

            if (ele > cap)
                return false;
            if (onGoingCap > cap) {
                currDay++;
                onGoingCap = ele;

                if (currDay > days)
                    return false;
            }
        }

        return true;
    }
}
