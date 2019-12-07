//https://leetcode.com/problems/jump-game/submissions/
package medium.dp;

public class JumpGame {
    public static void main(String[] args) {
        System.out.println(new JumpGame().canJump(new int[]{2, 0, 0}));
    }

    public boolean canJump(int[] nums) {
        int len = nums.length;
        if (len < 2)
            return true;

        if (nums[0] == 0)
            return false;

        for (int i = 1; i < len - 1; i++) {
            nums[i] = (nums[i] > nums[i - 1] - 1) ? nums[i] : nums[i - 1] - 1;
            if (nums[i] == 0) {
                return false;
            }
        }
        return true;
    }
}
