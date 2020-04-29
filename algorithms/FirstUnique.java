//https://leetcode.com/explore/featured/card/30-day-leetcoding-challenge/531/week-4/3313/

import java.util.*;

public class FirstUnique {
    private Map<Integer, Integer> counter = new LinkedHashMap<>();
    private Set<Integer> unique = new LinkedHashSet<>();

    public FirstUnique(int[] nums) {
        for (int num : nums)
            counter.put(num, counter.getOrDefault(num, 0) + 1);

        counter.forEach((num, count) -> {
            if (count == 1) unique.add(num);
        });
    }

    public int showFirstUnique() {
        if (!unique.isEmpty()) {
            return unique.iterator().next();
        }
        return -1;
    }

    public void add(int value) {
        int count = counter.getOrDefault(value, 0);

        if (count == 0) unique.add(value);

        if (count == 1) unique.remove(value);

        counter.put(value, count + 1);
    }
}
