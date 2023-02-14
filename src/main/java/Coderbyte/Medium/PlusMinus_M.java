package Coderbyte.Medium;

public class PlusMinus_M {

    static String result = "not possible";

    public static String PlusMinus_M(int num) {

        char[] digits = String.valueOf(num).toCharArray();
        int index = 1;

        calculate(digits, index, (digits[0] - 48), "");

        return result;
    }

    private static void calculate(char[] digits, int index, int sum, String expres) {

        if (index == digits.length && sum == 0) {
            result = expres;
            return;
        }

        if (index == digits.length && sum != 0) {
            return;
        }

        calculate(digits, index + 1, sum + ((digits[index] - 48)), expres + "+");
        calculate(digits, index + 1, sum - ((digits[index] - 48)), expres + "-");

    }

    public static void main(String[] args) {
        System.out.println(PlusMinus_M(199));
        System.out.println(PlusMinus_M(26712));
    }


}