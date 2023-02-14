package Coderbyte.Easy;

import java.util.Stack;

public class NumberReverse_M {

    public static String NumberReverse(String str) {
        StringBuilder result = new StringBuilder();

        Stack<Integer> stack = new Stack<Integer>();

        String digit = "";

        int i = 0;

        for (; i < str.length(); i++) {

            while (i < str.length() && Character.isDigit(str.charAt(i))) {
                digit += "" + str.charAt(i);
                i++;
            }


            stack.add(Integer.parseInt(digit));

            digit = "";
        }

        while (stack.size() > 0) {
            result.append(stack.pop() + " ");
        }

        return result.toString();
    }

    public static void main(String[] args) {
        System.out.println(NumberReverse("1 2 3"));
        System.out.println(NumberReverse("10 20 50"));

        System.out.println(NumberReverse("12334453412213"));
    }
}
