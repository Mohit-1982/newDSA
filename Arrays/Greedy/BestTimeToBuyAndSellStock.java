Leetcode - 121
  Optimal :   
    class Solution {
    public int maxProfit(int[] prices) {
        int i = 1;
        int profit = 0;
        int price = prices[0];
        int n = prices.length;
    
        while (i < n) {
            int priceDiff = prices[i] - price;

            if (priceDiff < 0) {
                //loss
                price = prices[i];
            }  

            profit = Math.max(profit, priceDiff);
            i++;
        }

        return profit;
    }
}
