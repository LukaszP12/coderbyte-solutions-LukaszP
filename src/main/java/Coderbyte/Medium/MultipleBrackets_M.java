package Coderbyte.Medium;

import java.util.Stack;

public class MultipleBrackets_M {

    public static String MultipleBrackets_M(String str) {

        Stack<Character> stack1 = new Stack<>();
        Stack<Character> stack2 = new Stack<>();
        int counter = 0;

        for (int i = 0; i < str.length(); i++) {
            char charAt = str.charAt(i);

            if (charAt == '(') {
                stack1.add('(');
            }

            if (charAt == '[') {
                stack2.add('[');
            }

            if (charAt == ')') {
                if (!stack1.isEmpty()) {
                    stack1.pop();
                    counter++;
                } else {
                    return "0";
                }
            }

            if (charAt == ']') {
                if (!stack2.isEmpty()) {
                    stack2.pop();
                    counter++;
                } else {
                    return "0";
                }
            }

        }

        if (!stack1.isEmpty() || !stack2.isEmpty()) {
            return "0";
        }

        return counter > 0 ? 1 + " " + counter : "0";
    }

    public static void main(String[] args) {
        String s = "(coder)[byte)]";
        System.out.println(MultipleBrackets_M(s));

        String s1 = "(c([od]er)) b(yt[e])";
        System.out.println(MultipleBrackets_M(s1));
    }

}
