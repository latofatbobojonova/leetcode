//https://leetcode.com/problems/maximum-subarray/
package top_interview_easy.dp;

public class MaxSubarray {
    public int maxSubArray(int[] nums) {
        int len = nums.length;

        int prevMax = nums[0];
        int overAllMax = nums[0];

        for (int i = 1; i < len; i++) {
            // Max sum of subarray whose last index is i
            prevMax = (prevMax + nums[i] > nums[i]) ? prevMax + nums[i] : nums[i];

            overAllMax = (overAllMax < prevMax) ? prevMax : overAllMax;
        }

        return overAllMax;
    }
}
