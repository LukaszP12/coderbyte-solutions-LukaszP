package Coderbyte.Easy;

public class HappyNumbers_M {

    public static boolean HappyNumbers(int num) {
        int init_num = num;

        while (true) {
            if (toSquares(num) == 1) {
                return true;
            }

            num = toSquares(num);

            if (init_num == num) {
                return false;
            }
        }

    }

    private static int toSquares(int num) {
        if (num < 10) {
            return (int) Math.pow(num, 2);
        } else {
            String number = String.valueOf(num);
            char[] charArray = number.toCharArray();
            int result = 0;

            for (int i = 0; i < charArray.length; i++) {
                result += (int) Math.pow(Integer.parseInt("" + charArray[i]), 2);
            }
            return result;
        }

    }

    public static void main(String[] args) {
        System.out.println(HappyNumbers(49));

        // incorrect time runs out
        System.out.println(HappyNumbers(101));
        System.out.println(HappyNumbers(2));
    }

}