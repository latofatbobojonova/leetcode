//https://leetcode.com/explore/featured/card/30-day-leetcoding-challenge/529/week-2/3291/


import java.util.Stack;

public class BackspaceStringCompare {
    public boolean backspaceCompare(String S, String T) {
        if (S == null || T == null) return false;
        Stack<Character> s = new Stack<>();
        Stack<Character> t = new Stack<>();

        for (int i = 0; i < S.length(); i++) {
            if (S.charAt(i) == '#') {
                if (!s.empty())
                    s.pop();
            } else {
                s.push(S.charAt(i));
            }
        }

        for (int i = 0; i < T.length(); i++) {
            if (T.charAt(i) == '#') {
                if (!t.empty())
                    t.pop();
            } else {
                t.push(T.charAt(i));
            }
        }

        if (s.size() != t.size())
            return false;

        while (!s.empty()) {
            if (s.pop() != t.pop())
                return false;
        }

        return true;
    }

    public String backspace(String s) {
        int p = 0;
        int len = s.length();

        for (int i = 0; i < len; i++) {
            if (s.charAt(i) != '#') {
                p = i;
            } else {

            }
        }

        return s;
    }

//    public boolean compare(String S, String T) { // To compare a******b and ab
//        int lenS = S.length();
//        int lenT = T.length();
//        int i = 0;
//        int j = 0;
//
//        while (i < lenS || j < lenT) {
//
//            if (S.charAt(i) == '*') {
//                i++;
//            } else if (T.charAt(j) == '*') {
//                j++;
//            } else if (S.charAt(i) != T.charAt(i)) {
//                return false;
//            } else {
//                i++;
//                j++;
//            }
//        }
//
//        return true;
//    }
}

/*
 * I approach: Stack ----> Time O(n), Memory O(n)
 * if(S[i] == '#')
 *   sStack.pop()
 * else
 *   sStack.push(S[i])
 *
 *
 *
 * II approach: Two pointers ---> Time O(n), Memory O(1)
 *
 *   S = ab#c    T = ad#c
 *
 *   p1, p2 = 0  ---> all p1 and p2 are adjacent not deleted chars position
 *
 * if(S[p2] != '#')
 *   p1 = p2
 *   p2 ++;
 *
 * else
 *   S[p1] = '*'  --> means deleted ====> WARNING IS NOT POSSIBLE TO DO IN-PLACE USING JAVA
 *   S[p2] = '*'
 *   p1 --;
 *   p2 ++;
 *
 *
 * Debug:
 *
 *
 *   p1, p2 = 0
 *
 * S[0] = a
 * p1 = p2 = 0
 * p2 = 1
 *
 * S[1] = b
 * p1 = p2 = 1
 * p2 = 2
 *
 * S[2] = #
 * S[1] = #
 * p1 = 0
 * p2 = 3
 *
 * S[3] = c
 * p1 = p2 = 3
 * p2 = 4
 * */