//https://leetcode.com/explore/featured/card/30-day-leetcoding-challenge/531/week-4/3307/

import java.util.HashMap;

public class SubarraySumEqualsK {
    public int subarraySum(int[] nums, int k) {
        if (nums == null || nums.length == 0)
            return 0;

        int len = nums.length;

        HashMap<Integer, Integer> sumFreq = new HashMap<>();

        int count = 0;
        int sum = nums[0];

        if(sum == k){
            count++;
        }

        sumFreq.put(sum, 1);

        for (int i = 1; i < len; i++) {
            sum = sum + nums[i];

            if(sumFreq.containsKey(sum - k)){
                count += sumFreq.get(sum - k);
            }

            if(sum == k){
                count++;
            }

            if (sumFreq.containsKey(sum)){
                sumFreq.put(sum, sumFreq.get(sum) + 1);
            } else {
                sumFreq.put(sum, 1);
            }
        }

        return count;
    }
}
