package Coderbyte.Medium;

public class CaesarCipher_M {

    public static String CaesarCipher_M(String str, int num) {
        String result = "";

        char[] chars = str.toCharArray();

        for (int i = 0; i < chars.length; i++) {
            int j = chars[i];
            char shiftChar = (char) (j + num);

            if (Character.isLowerCase(chars[i]) && (j + num) > 122) {
                int i1 = (j + num) - 123;
                char ch1 = (char) (97 + i1);
                result += ch1;
            } else if (Character.isUpperCase(chars[i]) && (j + num) > 90) {
                int i1 = (j + num) - 91;
                char ch1 = (char) (65 + i1);
                result += ch1;
            } else if (Character.isLetterOrDigit(shiftChar)) {
                result += shiftChar;
            } else {
                result += chars[i];
            }

        }

        return result;
    }

    public static void main(String[] args) {
        String hello = CaesarCipher_M("world!", 1);
        System.out.println(hello);

        String hello1 = CaesarCipher_M("coderBYTE", 2);
        System.out.println(hello1);

        String hello2 = CaesarCipher_M("some change", 1);
        System.out.println(hello2);

        String hello3 = CaesarCipher_M("byte", 13);
        System.out.println(hello3);
    }

}