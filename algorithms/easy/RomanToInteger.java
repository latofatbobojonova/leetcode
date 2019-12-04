package easy;

import java.util.HashMap;
import java.util.Map;

public class RomanToInteger {
    public int romanToInt(String s) {
        Map<Character, Integer> symbolsMap = new HashMap<>();
        symbolsMap.put('I', 1);
        symbolsMap.put('V', 5);
        symbolsMap.put('X', 10);
        symbolsMap.put('L', 50);
        symbolsMap.put('C', 100);
        symbolsMap.put('D', 500);
        symbolsMap.put('M', 1000);

        int sLen = s.length();
        int sum = 0;
        int cursorNum;

        for (int i = 0; i < sLen; i++) {
            cursorNum = symbolsMap.get(s.charAt(i));
            if (i + 1 < sLen && cursorNum < symbolsMap.get(s.charAt(i + 1))) {
                cursorNum = -cursorNum;
            }
            sum += cursorNum;
        }

        return sum;
    }
}
