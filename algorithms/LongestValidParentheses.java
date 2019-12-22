//https://leetcode.com/problems/longest-valid-parentheses/

public class LongestValidParentheses {
    public int longestValidParentheses(String s) {
        int sLen = s.length();
        if (sLen == 0) return 0;

        int[] longestLen = new int[sLen];
        char c;
        int max = 0;

        for (int i = 1; i < sLen; i++) {                        // longestLen[0] is always 0
            c = s.charAt(i);

            if (c == ')') {                                     // If c = '(' remain longestLen[i] as 0
                if (s.charAt(i - 1) == '(') {
                    longestLen[i] = ((i != 1) ? longestLen[i - 2] : 0) + 2;
                } else if (longestLen[i - 1] != 0 &&            // if prev is 0 then next is too '..))...'
                        i - longestLen[i - 1] >= 1 &&           // checking for index out of bounds for next 'and' condition
                        s.charAt(i - longestLen[i - 1] - 1) == '(') {   // found a pair for ')'
                    longestLen[i] = 2 + longestLen[i - 1] + ((i - longestLen[i - 1] < 2) ? 0 : longestLen[i - longestLen[i - 1] - 2]);
                }
                if (longestLen[i] > max) max = longestLen[i];
            }
        }
        return max;
    }
}
