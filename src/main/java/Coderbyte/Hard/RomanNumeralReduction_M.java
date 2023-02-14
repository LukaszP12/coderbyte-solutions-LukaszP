package Coderbyte.Hard;

public class RomanNumeralReduction_M {

    private static final int[] VALUES = new int[]{1000, 500, 100, 50, 10, 5, 1};
    private static final String NUMERALS = "MDCLXVI";

    public static String RomanNumeralReduction_M(String str) {

        int number = romanToInt(str);

        return intToRoman(number);
    }

    private static String intToRoman(int number) {

        StringBuilder roman = new StringBuilder();

        for (int i = 0; i < VALUES.length; i++) {
            while (number >= VALUES[i]) {
                number = number - VALUES[i];
                roman.append(NUMERALS.charAt(i));
            }
        }

        return roman.toString();
    }

    public static int romanToInt(String str) {
        int sum = 0;

        int previous = 0;

        for (int i = str.length() - 1; i >= 0; i--) {
            int value = VALUES[NUMERALS.indexOf(str.charAt(i))];
            if (value < previous) {
                sum -= value;
            } else {
                sum += value;
            }
            previous = value;
        }

        return sum;
    }

    public static void main(String[] args) {
        String s = "XXXVVIIIIIIIIII";
        System.out.println(RomanNumeralReduction_M(s));

        String s1 = "DDLL";
        System.out.println(RomanNumeralReduction_M(s1));

//        System.out.println(romanToInt("LIV"));
    }

}
