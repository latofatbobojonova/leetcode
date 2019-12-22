//https://leetcode.com/problems/decode-ways/

public class DecodeWays {
    public int numDecodings(String s) {
        int len = s.length();
        int[] dp = new int[len];

        char chCurrent = s.charAt(0);
        char chPrev;

        if (chCurrent == '0')
            return 0;

        dp[0] = 1;

        if (len > 1) {
            chPrev = chCurrent;
            chCurrent = s.charAt(1);

            if (chCurrent == '0') {
                if (chPrev > '2')
                    return 0;

                dp[1] = 1;
            } else if (chCurrent <= '6' && chPrev == '2' || chPrev == '1') {
                dp[1] = 2;
            } else {
                dp[1] = 1;
            }
        }

        for (int i = 2; i < len; i++) {
            chCurrent = s.charAt(i);
            chPrev = s.charAt(i - 1);

            if (chCurrent == '0') {
                if (chPrev == '0' || chPrev > '2')
                    return 0;

                dp[i] = dp[i - 2];
            } else if (chCurrent <= '6' && chPrev == '2' || chPrev == '1') {
                dp[i] = dp[i - 1] + dp[i - 2];
            } else {
                dp[i] = dp[i - 1];
            }
        }

        return dp[len - 1];
    }
}
