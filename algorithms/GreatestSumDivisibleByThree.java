//https://leetcode.com/problems/greatest-sum-divisible-by-three/

public class GreatestSumDivisibleByThree {
    public int maxSumDivThree(int[] nums) {
        int len = nums.length;
        int reminderOneMin1 = 0;
        int reminderOneMin2 = 0;
        int reminderTwoMin1 = 0;
        int reminderTwoMin2 = 0;
        int totalSum = 0;

        for (int i = 0; i < len; i++) {
            if (nums[i] % 3 == 2) {
                if (reminderTwoMin1 == 0 || reminderTwoMin1 >= nums[i]) {
                    reminderTwoMin2 = reminderTwoMin1;
                    reminderTwoMin1 = nums[i];
                } else if (reminderTwoMin2 == 0 || reminderTwoMin2 > nums[i]) {
                    reminderTwoMin2 = nums[i];
                }
            } else if (nums[i] % 3 == 1) {
                if (reminderOneMin1 == 0 || reminderOneMin1 >= nums[i]) {
                    reminderOneMin2 = reminderOneMin1;
                    reminderOneMin1 = nums[i];
                } else if (reminderOneMin2 == 0 || reminderOneMin2 > nums[i]) {
                    reminderOneMin2 = nums[i];
                }
            }
            totalSum += nums[i];
        }

        if (totalSum % 3 == 1) {
            if (reminderOneMin1 == 0) {
                totalSum -= (reminderTwoMin1 + reminderTwoMin2);
            } else if (reminderTwoMin2 == 0) {
                totalSum -= reminderOneMin1;
            } else {
                totalSum -= (reminderOneMin1 < reminderTwoMin1 + reminderTwoMin2) ? reminderOneMin1 : (reminderTwoMin1 + reminderTwoMin2);
            }
        } else if (totalSum % 3 == 2) {
            if (reminderTwoMin1 == 0) {
                totalSum -= (reminderOneMin1 + reminderOneMin2);
            } else if (reminderOneMin2 == 0) {
                totalSum -= reminderTwoMin1;
            } else {
                totalSum -= (reminderTwoMin1 < reminderOneMin1 + reminderOneMin2) ? reminderTwoMin1 : (reminderOneMin1 + reminderOneMin2);
            }
        }

        return totalSum;
    }
}
