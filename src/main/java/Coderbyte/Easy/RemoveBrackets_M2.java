package Coderbyte.Easy;

import java.util.Stack;

public class RemoveBrackets_M2 {


    public static int RemoveBrackets_M2(String str) {
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < str.length(); i++) {

            if (stack.isEmpty() && str.charAt(i) == ')') {
                stack.add(')');
                continue;
            }

            if (str.charAt(i) == '(') {
                stack.add('(');
            }

            if (!stack.isEmpty() && str.charAt(i) == ')') {
                stack.pop();
            }

        }

        return stack.size();
    }


    public static void main(String[] args) {
        String s = ")(()";
        System.out.println(RemoveBrackets_M2(s));

        System.out.println(RemoveBrackets_M2("(())()((("));
        System.out.println(RemoveBrackets_M2("(()("));
    }

}
