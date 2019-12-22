//https://leetcode.com/problems/maximum-product-subarray/

public class MaxProductSubArray {
    public int maxProduct(int[] nums) {
        int len = nums.length;
        int[][] dp = new int[len][2]; // Max Positive and Min Negative Products of subarray ending at nums[i]
        int max = nums[0];
        dp[0][0] = nums[0] > 0 ? nums[0] : 0;
        dp[0][1] = nums[0] < 0 ? nums[0] : 0;

        for (int i = 1; i < len; i++) {

            dp[i][0] = max(dp[i - 1][0] * nums[i], nums[i], dp[i - 1][1] * nums[i]);
            dp[i][1] = min(dp[i - 1][1] * nums[i], nums[i], dp[i - 1][0] * nums[i]);

            if (max < dp[i][0]) {
                max = dp[i][0];
            }
        }

        return max;
    }

    public int max(int a, int b, int c) {
        int max = a > b ? a : b;
        return max > c ? max : c;
    }

    public int min(int a, int b, int c) {
        int min = a > b ? b : a;
        return min > c ? c : min;
    }
}
