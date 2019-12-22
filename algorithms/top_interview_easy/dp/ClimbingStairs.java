//https://leetcode.com/problems/climbing-stairs/

package top_interview_easy.dp;

public class ClimbingStairs {
    public int climbStairs(int n) {
        int dp = 1;
        int dp1 = 0;

        for (int i = 0; i <= n; i++) {
            dp1 = dp1 + dp;
            dp = dp1 - dp;
        }
        return dp1;
    }
}
