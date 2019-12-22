//https://leetcode.com/problems/rotate-array/

public class RotateArray {
    public void rotate(int[] nums, int k) {
        int len = nums.length;
        int changer;
        int seenNumbers = 0;
        int startPoint = 0;
        int i = 0;

        int temp;
        while (++seenNumbers < len) {
            changer = nums[i];
            i = (i + k) % len;
            do {
                temp = nums[i];
                nums[i] = changer;
                changer = temp;
                i = (i + k) % len;
                seenNumbers++;
            } while (i != startPoint);

            nums[i] = changer;
            startPoint = ++i;
        }
    }
}
