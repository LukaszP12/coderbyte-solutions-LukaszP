package Coderbyte.Easy;

public class SerialNumber_M {

//    1. It needs to contain three sets each with three digits (1 through 9)
//    separated by a period.
//    2. The first set of digits must add up to an even number.
//    3. The second set of digits must add up to an odd number.
//    4. The last digit in each set must be larger than
//    the two previous digits in the same set.

    public static String SerialNumber(String str) {
        String[] split = str.split("\\.");

        // 1. condition
        if (split.length != 3) return "false";

        boolean matches = str.matches("\\d{3}\\.\\d{3}\\.\\d{3}");
        if (!matches) {
            return "false";
        }


        // 2. condition
        String firstSet = split[0];
        char[] charArray = firstSet.toCharArray();
        int sumOfFirstSet = 0;

        for (int i = 0; i < charArray.length; i++) {
            sumOfFirstSet += Integer.parseInt("" + charArray[i]);
        }

        if (sumOfFirstSet % 2 != 0) {
            return "false";
        }

        // 3. condition
        String secondSet = split[1];
        char[] charArray1 = secondSet.toCharArray();
        int sumOfSecondSet = 0;

        for (int i = 0; i < charArray.length; i++) {
            sumOfSecondSet += Integer.parseInt("" + charArray1[i]);
        }

        if (sumOfSecondSet % 2 == 0) {
            return "false";
        }

        // 4. condition
        for (String s : split) {
            if (s.charAt(2) > s.charAt(1) && s.charAt(2) > s.charAt(0)) {
                continue;
            } else {
                return "false";
            }

        }

        return "true";
    }

    public static void main(String[] args) {
        String s = "11.124.667";
        System.out.println(SerialNumber(s));

        String s1 = "114.568.112";
        System.out.println(SerialNumber(s1));
    }

}
