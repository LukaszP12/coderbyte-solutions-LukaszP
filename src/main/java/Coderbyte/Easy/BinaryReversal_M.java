package Coderbyte.Easy;

public class BinaryReversal_M {

    public static String BinaryReversal(String str) {

        String s = decimalToBinary(Integer.parseInt(str));

        s = padUp(s);

        s = reverse(s);

        return String.valueOf(BinaryToDecimal(s));
    }

    private static String reverse(String s) {
        return new StringBuilder(s).reverse().toString();
    }

    private static int BinaryToDecimal(String s) {
        s = reverse(s);

        int result = 0;
        if (s.charAt(0) == '1') {
            result += 1;
        }

        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == '1') {
                result += Math.pow(2, i);
            }
        }

        return result;
    }

    private static String padUp(String s) {
        if (s.length() >= 8) {
            return s;
        } else {
            int length = s.length();

            s = reverse(s);

            for (int i = length; i < 8; i++) {
                s += "" + 0;
            }

            return reverse(s);

        }

    }

    private static String decimalToBinary(int num) {

        String binary = "";

        while (num > 0) {
            if (num % 2 == 1) {
                binary += "" + 1;
            } else {
                binary += "" + 0;
            }

            num = num / 2;
        }

        return new StringBuilder(binary).reverse().toString();
    }

    public static void main(String[] args) {
        System.out.println(BinaryReversal("47"));
        System.out.println(BinaryReversal("213"));

        // wrong cases
        System.out.println(BinaryReversal("4567"));

        // 1000111010111
        // 1 + 16 + 32+ 64 + 256 + 1024 + 2048 + 4096

        System.out.println(BinaryReversal("12345"));
        System.out.println(BinaryReversal("10156"));
    }
}
