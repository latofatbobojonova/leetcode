//https://leetcode.com/problems/coin-change/
package top_interview_medium.dp;

public class CoinChange {
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];

        for (int i = 1; i <= amount; i++) {
            int min = Integer.MAX_VALUE;

            for (int coin : coins) {
                if (i < coin)
                    continue;

                if (min > 0 && dp[i - coin] < min && dp[i - coin] >= 0)
                    min = dp[i - coin];
            }
            dp[i] = min + 1;
        }

        if (dp[amount] < 0)
            return -1;

        return dp[amount];
    }
}
