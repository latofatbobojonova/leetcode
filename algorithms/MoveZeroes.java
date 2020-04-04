//https://leetcode.com/explore/featured/card/30-day-leetcoding-challenge/528/week-1/3286/


public class MoveZeroes {
    public void moveZeroes(int[] nums) {
        int p1 = 0, p2 = 1;
        int len = nums.length;
        int temp;

        while (p2 < len) {
            if (nums[p1] == 0) {
                if (nums[p2] == 0) {
                    p2++;
                } else {
                    temp = nums[p1];
                    nums[p1] = nums[p2];
                    nums[p2] = temp;
                    p1++;
                    p2++;
                }
            } else {
                p1++;
                p2++;
            }
        }
    }
}