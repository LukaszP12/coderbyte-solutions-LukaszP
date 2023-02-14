package Coderbyte.Medium;

public class MissingDigit_M {

    public static int MissingDigit_M(String str) {
        String[] split = str.split("\\s");

        String num1 = split[0];

        String operand = split[1];

        String num2 = split[2];

        String result = split[4];

        if (num1.contains("x")) {
            int cal = calculate(result, num2, flipOperator(operand));

            return getX(cal, num1);
        }

        if (num2.contains("x")) {
            int cal = calculate(result, num1, flipOperator(operand));

            return getX(cal, num2);
        }

        if (result.contains("x")) {
            int calc = calculate(num1, num2, operand);

            return getX(calc, result);
        }


        return 0;
    }

    private static String flipOperator(String operand) {
        if (operand.equals("+")) {
            return "-";
        }

        if (operand.equals("-")) {
            return "+";
        }

        if (operand.equals("*")) {
            return "/";
        }

        if (operand.equals("/")) {
            return "*";
        }

        return "";
    }


    private static int getX(int calc, String result) {

        int index = result.indexOf("x");

        return (String.valueOf(calc).charAt(index) - 48);
    }

    private static int calculate(String num1, String num2, String operand) {
        int n1 = Integer.parseInt(num1);
        int n2 = Integer.parseInt(num2);

        if (operand.contains("+")) {
            return n1 + n2;
        }

        if (operand.contains("-")) {
            return n1 - n2;
        }

        if (operand.contains("*")) {
            return n1 * n2;
        }

        if (operand.contains("/")) {
            if (n2 != 0) {
                return n1 / n2;
            }
        }

        return 0;
    }


    public static void main(String[] args) {
//        String examp1 = "4 - 2 = x";
//        System.out.println(MissingDigit_M(examp1));

//        System.out.println(MissingDigit_M(examp1));
//        System.out.println(MissingDigit_M("1x0 * 12 = 1200"));

//        String s = "3x + 12 = 46";
//        System.out.println(MissingDigit_M(s));
        // incorrect cases

        String s1 = "10 - x = 10";
        System.out.println(MissingDigit_M(s1));
    }

}