//https://leetcode.com/problems/best-time-to-buy-and-sell-stock/

public class BestTimeBuySellStock {
    public int maxProfit(int[] prices) {
        int len = prices.length;
        if (len == 0) return 0;

        int maxPrice = prices[len - 1]; // Max price between days from i+1 to len
        int maxProfit = 0;  // Max profit from selling and buying stock between days from i+1 to len
        int diff;

        for (int i = len - 2; i >= 0; i--) {
            maxPrice = (maxPrice < prices[i]) ? prices[i] : maxPrice;
            maxProfit = (maxProfit < (diff = maxPrice - prices[i])) ? diff : maxProfit;
        }

        return maxProfit;
    }
}
