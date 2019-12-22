//https://leetcode.com/problems/minimum-falling-path-sum-ii/

public class MinimumFallingPathSumII {
    public int minFallingPathSum(int[][] arr) {
        int m = arr.length;

        if (m == 1) {
            return arr[0][0];
        }

        for (int i = 0; i < m - 1; i++) {
            int[][] mins = findTwoMinAndIndex(arr[i]);
            for (int j = 0; j < m; j++) {
                if (j == mins[0][1]) {
                    arr[i + 1][j] = arr[i + 1][j] + mins[1][0];
                } else {
                    arr[i + 1][j] = arr[i + 1][j] + mins[0][0];
                }
            }
        }

        int minSum = Integer.MAX_VALUE;
        for (int i = 0; i < m; i++) {
            if (minSum > arr[m - 1][i]) {
                minSum = arr[m - 1][i];
            }
        }

        return minSum;
    }

    public int[][] findTwoMinAndIndex(int[] nums) {
        int min1 = -100, min2 = -100;
        int index1 = 0, index2 = 0;
        int len = nums.length;

        int[][] res = new int[2][2];
        for (int i = 0; i < len; i++) {
            if (min1 == -100 || min1 > nums[i]) {
                min2 = min1;
                min1 = nums[i];
                index2 = index1;
                index1 = i;
            } else if (min2 == -100 || min2 > nums[i]) {
                min2 = nums[i];
                index2 = i;
            }
        }

        res[0][0] = min1;
        res[0][1] = index1;
        res[1][0] = min2;
        res[1][1] = index2;

        return res;
    }
}
