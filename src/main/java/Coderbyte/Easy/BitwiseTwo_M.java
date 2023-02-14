package Coderbyte.Easy;

public class BitwiseTwo_M {

    public static String BitwiseTwo_M(String[] strArr) {
        String s = strArr[0];
        String s1 = strArr[1];
        String result = "";

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '1' && s1.charAt(i) == '1') {
                result += "" + 1;
            } else {
                result += "" + 0;
            }

        }

        return result;
    }

    public static void main(String[] args) {
        String[] strings = {"100", "000"};
        System.out.println(BitwiseTwo_M(strings));

        String[] strings1 = {"10100", "11100"};
        System.out.println(BitwiseTwo_M(strings1));
    }

}