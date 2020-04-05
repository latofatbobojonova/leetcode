//https://leetcode.com/explore/featured/card/30-day-leetcoding-challenge/528/week-1/3287/


public class BestTimeBuySellStockII {
    public int maxProfit(int[] prices) {
        int len = prices.length;
        if (len == 0) return 0;

        int sum = 0;
        int index = 0;

        while (index < len) {
            int buy = findNextFall(prices, index);
            index = buy + 1;

            if (index < len) {
                int sell = findNextPick(prices, index);
                sum += (prices[sell] - prices[buy]);
                index = sell + 1;
            }
        }

        return sum;
    }

    public int findNextPick(int[] a, int lo) {
        int len = a.length;

        for (int i = lo; i < len; i++) {
            if (i < len - 1 && a[i] > a[i + 1]) {
                return i;
            }
        }

        return len - 1;
    }

    public int findNextFall(int[] a, int lo) {
        int len = a.length;

        for (int i = lo; i < len; i++) {
            if (i < len - 1 && a[i] < a[i + 1]) {
                return i;
            }
        }

        return len - 1;
    }
}
