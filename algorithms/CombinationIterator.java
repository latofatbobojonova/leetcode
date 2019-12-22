//https://leetcode.com/problems/iterator-for-combination/

import java.util.ArrayList;
import java.util.List;

public class CombinationIterator {
    String characters;
    int combinationLength;
    int currentCombinationNumber;
    List<String> combinations = new ArrayList<>();

    public CombinationIterator(String characters, int combinationLength) {
        this.characters = characters;
        this.combinationLength = combinationLength;
        generateCombination("", 0);
        currentCombinationNumber = -1;
    }

    public static void main(String[] args) {
        CombinationIterator iterator = new CombinationIterator("abc", 2);
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }

    public void generateCombination(String word, int i) {
        if (i > characters.length() - 1) {
            return;
        }
        if (word.length() + 1 == combinationLength) {
            combinations.add(word + characters.charAt(i));
            generateCombination(word, i + 1);
        } else {
            generateCombination(word + characters.charAt(i), i + 1);
            generateCombination(word, i + 1);
        }
    }

    public String next() {
        if (hasNext()) {
            currentCombinationNumber++;
            return combinations.get(currentCombinationNumber);
        }
        return null;
    }

    public boolean hasNext() {
        return currentCombinationNumber != combinations.size() - 1;
    }
}
