//https://leetcode.com/explore/featured/card/30-day-leetcoding-challenge/528/week-1/3288/

import java.util.*;

public class GroupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {

        if (strs.length == 0) return new ArrayList<>();

        Map<String, List<String>> anagramsMap = new HashMap<>();
        int[] letterCount = new int[26];

        for (String word : strs) {
            Arrays.fill(letterCount, 0);

            for (char letter : word.toCharArray()) letterCount[letter - 'a']++;

            StringBuilder expr = new StringBuilder("");

            for (int i = 0; i < 26; i++) {
                expr.append("-").append(letterCount[i]);
            }

            String key = expr.toString();

            if (!anagramsMap.containsKey(key))
                anagramsMap.put(key, new ArrayList<>());

            anagramsMap.get(key).add(word);
        }

        return new ArrayList<>(anagramsMap.values());
    }
}
