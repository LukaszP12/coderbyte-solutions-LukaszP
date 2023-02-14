package Coderbyte.Medium;

import java.util.ArrayList;
import java.util.List;

public class TripleDouble_M {

    public static int TripleDouble_M(int num1, int num2) {

        // first number
        String s1 = String.valueOf(num1);
        boolean strTriple = false;

        // second number
        String s2 = String.valueOf(num2);
        boolean strDouble = false;


        List<Integer> answers = new ArrayList<Integer>();


        for (int i = 2; i < s1.length(); i++) {
            int digit1 = Integer.parseInt(s1.charAt(i - 2) + "");
            int digit2 = Integer.parseInt(s1.charAt(i - 1) + "");
            int digit3 = Integer.parseInt(s1.charAt(i) + "");

            if (digit1 == digit2 && digit1 == digit3) {
                answers.add(digit3);
                strTriple = true;
            }
        }


        // second number

        for (int i = 1; i < s2.length(); i++) {
            int digit1 = Integer.parseInt(s2.charAt(i - 1) + "");
            int digit2 = Integer.parseInt(s2.charAt(i) + "");

            if (digit1 == digit2 && answers.contains(digit2)) {
                strDouble = true;
            }
        }

        if (strTriple && strDouble) {
            return 1;
        }

        return 0;
    }

    public static void main(String[] args) {
        System.out.println(TripleDouble_M(465555, 5579));
        System.out.println(TripleDouble_M(333, 33));
        System.out.println(TripleDouble_M(555666, 5589));

        System.out.println(TripleDouble_M(556668, 556886));

        System.out.println(TripleDouble_M(17555, 55144));
        System.out.println(TripleDouble_M(800000006, 7800));
    }
}
