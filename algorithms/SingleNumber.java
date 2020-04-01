//https://leetcode.com/explore/featured/card/30-day-leetcoding-challenge/528/week-1/3283/


public class SingleNumber {
    public int singleNumber(int[] nums) {
        int len = nums.length;
        int xor = 0;

        for (int i = 0; i < len; i++) {
            xor ^= nums[i];
        }
        return xor;
    }
}



