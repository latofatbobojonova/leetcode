//https://leetcode.com/problems/house-robber/
package top_interview_easy.dp;

public class HouseRobber {
    public int rob(int[] nums) {
        int len = nums.length;
        int[] dp = new int[len];

        if (len == 0) {
            return 0;
        }

        if (len == 1) {
            return nums[0];
        }

        dp[0] = nums[0];
        dp[1] = nums[1];

        if (len > 2)
            dp[2] = nums[0] + nums[2];

        for (int i = 3; i < len; i++) {
            dp[i] = max(dp[i - 2], dp[i - 3]) + nums[i];
        }

        return max(dp[len - 2], dp[len - 1]);
    }

    public int max(int a, int b) {
        return (a > b) ? a : b;
    }
}
