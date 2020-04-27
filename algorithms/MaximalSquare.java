//https://leetcode.com/problems/maximal-square/

public class MaximalSquare {
    public int maximalSquare(char[][] matrix) {

        if (matrix.length == 0 || matrix[0].length == 0)
            return 0;

        int m = matrix.length;
        int n = matrix[0].length;

        int minMatrixSide = Math.min(m, n);

        int[][] dp = new int[m][n];
        int maxSquareSide = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                dp[i][j] = (matrix[i][j] == '1') ? 1 : 0;

                if (maxSquareSide == 0 && dp[i][j] == 1)
                    maxSquareSide = 1;
            }
        }

        if (maxSquareSide == 0) return 0;

        for (int k = 2; k <= minMatrixSide; k++) {

            for (int i = 0; i <= m - k; i++) {

                for (int j = 0; j <= n - k; j++) {

                    if (dp[i][j] == k - 1 && dp[i][j + 1] == k - 1 && dp[i + 1][j] == k - 1
                            && matrix[i + k - 1][j + k - 1] == '1')
                        dp[i][j] = k;

                    if (maxSquareSide == k - 1 && dp[i][j] == k)
                        maxSquareSide = k;
                }
            }

            if (maxSquareSide != k) {
                break;
            }
        }

        return maxSquareSide * maxSquareSide;
    }
}
}