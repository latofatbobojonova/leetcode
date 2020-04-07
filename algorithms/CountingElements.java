//https://leetcode.com/explore/challenge/card/30-day-leetcoding-challenge/528/week-1/3289/


import java.util.HashMap;
import java.util.Map;

public class CountingElements {

    public int countElements(int[] arr) {
        Map<Integer, Integer> elementCount = new HashMap<>();
        int result = 0;

        for (int value : arr) {
            if (elementCount.containsKey(value)) {
                elementCount.put(value, elementCount.get(value) + 1);
            } else {
                elementCount.put(value, 1);
            }
        }

        for (Map.Entry<Integer, Integer> entry : elementCount.entrySet()) {
            if (elementCount.containsKey(entry.getKey() + 1)) {
                result += entry.getValue();
            }
        }

        return result;
    }
}
