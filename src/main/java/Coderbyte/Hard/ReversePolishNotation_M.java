package Coderbyte.Hard;

import java.util.Stack;

public class ReversePolishNotation_M {


    public static int ReversePolishNotation_M(String str) {

        String[] split = str.trim().split(" ");

        Stack<Integer> numbers = new Stack<>();

        for (String s : split) {

            if (s.matches("\\d+")) {
                numbers.add(Integer.parseInt(s));
            } else if (s.matches("[\\+\\-\\*\\/]") && numbers.size() > 1) {
                int n1 = numbers.pop();
                int n2 = numbers.pop();
                String operation = s;

                if (operation.equals("+")) {
                    numbers.add(n1 + n2);
                } else if (operation.equals("-")) {
                    numbers.add(Math.abs(n1 - n2));
                } else if (operation.equals("*")) {
                    numbers.add(n1 * n2);
                } else if (operation.equals("/")) {

                    if (n1 > n2) {
                        numbers.add(n1 / n2);
                    } else {
                        numbers.add(n2 / n1);
                    }

                }

            }

        }

        return numbers.pop();
    }


    public static void main(String[] args) {
//        String s = "1 1 + 1 + 1 +";
//        System.out.println(ReversePolishNotation_M(s));

//        String s1 = "4 5 + 2 1 + *";
//        System.out.println(ReversePolishNotation_M(s1));

//        String s2 = "1 4 +";
//        System.out.println(ReversePolishNotation_M(s2));

//        String s4 = "1 4 5 2 - * + 5 *";
//        System.out.println(ReversePolishNotation_M(s4));

        // incorrect cases
//        String s3 = "2 12 + 7 /";
//        System.out.println(ReversePolishNotation_M(s3));

//        String s5 = "6 2 - 6 2 / * 4 +";
//        System.out.println(ReversePolishNotation_M(s5));

    }

}