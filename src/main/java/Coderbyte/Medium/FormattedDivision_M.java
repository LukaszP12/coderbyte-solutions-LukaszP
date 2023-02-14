package Coderbyte.Medium;

public class FormattedDivision_M {

    public static String FormattedDivision_M(int num1, int num2) {
        return String.format("%,.4f", ((double) num1) / ((double) num2));
    }

    public static void main(String[] args) {
        System.out.println(FormattedDivision_M(2, 3));
        System.out.println(FormattedDivision_M(10, 10));
    }

}
