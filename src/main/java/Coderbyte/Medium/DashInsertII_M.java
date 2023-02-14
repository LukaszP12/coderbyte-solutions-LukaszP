package Coderbyte.Medium;

public class DashInsertII_M {

    public static String DashInsertII_M(int num) {
        String input = String.valueOf(num);

        String result = "";

        for (int i = 1; i < input.length(); i++) {
            char firstChar = input.charAt(i - 1);
            char secondChar = input.charAt(i);

            if (isOdd(Integer.parseInt(firstChar + "")) && isOdd(Integer.parseInt(secondChar + ""))) {
                result += firstChar + "-";
            } else if (isEven(Integer.parseInt(firstChar + "")) && isEven(Integer.parseInt(secondChar + ""))) {
                result += firstChar + "*";
            } else {
                result += "" + firstChar;
            }

        }

        result += input.charAt(input.length() - 1);

        return result;
    }

    private static boolean isEven(int num) {
        if (num == 0) return false;

        if (num % 2 == 0) {
            return true;
        }

        return false;
    }

    private static boolean isOdd(int num) {
        if (num == 0) return false;

        if (num % 2 == 0) {
            return false;
        }

        return true;
    }

    public static void main(String[] args) {
        System.out.println(DashInsertII_M(99946));

        System.out.println(DashInsertII_M(56647304));
//        56*6*47-3-04


        System.out.println(DashInsertII_M(10120));

        System.out.println(DashInsertII_M(39904467));

//        System.out.println(DashInsertII_2(667488958374553));

//
//        System.out.println(DashInsertII_2(56647324));
//
//        // incorrect cases 10120
//        System.out.println(DashInsertII_2(10120));
//
//        // incorrect cases 60497642
//        System.out.println(DashInsertII_2(60497642));
    }
}
