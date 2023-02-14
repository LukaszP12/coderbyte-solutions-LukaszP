package Coderbyte.Medium;

import java.util.Stack;

public class BracketMatcher_M {

    public static int BracketMatcher_M(String str) {
        Stack<Character> stack = new Stack<Character>();

        if (str.length() == 0) return 0;

        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);

            if (stack.isEmpty() && c == '(') {
                stack.add(c);
            } else if (!stack.isEmpty() && c == '(') {
                stack.add(c);
            }

            if (stack.isEmpty() && c == ')') {
                return 0;
            } else if (!stack.isEmpty() && c == ')') {
                stack.pop();
            }

        }

        if (!stack.isEmpty()) {
            return 0;
        }

        return 1;
    }


    public static void main(String[] args) {
        String s = "(coder)(byte))";
        System.out.println(BracketMatcher_M(s));

        String s1 = "(c(oder)) b(yte)";
        System.out.println(BracketMatcher_M(s1));
    }

}
