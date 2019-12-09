//https://leetcode.com/problems/group-the-people-given-the-group-size-they-belong-to/
package medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupPeopleGroupSize {
    public List<List<Integer>> groupThePeople(int[] groupSizes) {
        List<List<Integer>> groups = new ArrayList<>();
        Map<Integer, List<Integer>> map = new HashMap<>();
        int len = groupSizes.length;

        for (int i = 0; i < len; i++) {
            if (map.get(groupSizes[i]) != null) {

                List<Integer> temp = map.get(groupSizes[i]);
                temp.add(i);
                map.put(groupSizes[i], temp);
            } else {
                List<Integer> list = new ArrayList<>();
                list.add(i);
                map.put(groupSizes[i], list);
            }

            if (map.get(groupSizes[i]).size() == groupSizes[i]) {
                groups.add(map.get(groupSizes[i]));
                map.put(groupSizes[i], new ArrayList<>());
            }
        }

        return groups;
    }
}
