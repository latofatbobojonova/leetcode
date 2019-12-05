//https://leetcode.com/problems/valid-parentheses/

package easy;

public class ValidParentheses {
    public boolean isValid(String s) {
        int sLen = s.length();
        StackChar parentheses = new StackChar();
        char current;

        for (int i = 0; i < sLen; i++) {
            current = s.charAt(i);

            if (current == '(' || current == '[' || current == '{') {
                parentheses.push(current);
                continue;
            } else if (parentheses.isEmpty())
                return false;

            char prev = parentheses.pop();

            if (!(prev == '[' && current == ']' ||
                    prev == '{' && current == '}' ||
                    prev == '(' && current == ')')) {
                return false;
            }

        }

        return parentheses.isEmpty();
    }

    private class StackChar {

        private Node first;

        boolean isEmpty() {
            return first == null;
        }

        void push(char item) {
            Node oldFirst = first;
            first = new Node(item);
            first.next = oldFirst;
        }

        char pop() {
            char item = first.value;
            first = first.next;
            return item;
        }

        private class Node {
            private char value;
            private Node next;

            Node(char val) {
                this.value = val;
            }
        }
    }
}
