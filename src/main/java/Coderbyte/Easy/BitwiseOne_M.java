package Coderbyte.Easy;

public class BitwiseOne_M {

    public static String BitwiseOne(String[] strArr) {
        String s = strArr[0];
        String s1 = strArr[1];

        String result = "";

        for (int i = 0; i < strArr[0].length(); i++) {
            if (s.charAt(i) == s1.charAt(i)) {
                result += "" + s.charAt(i);
            } else {
                result += "" + 1;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        String[] strings = {"100", "000"};
        System.out.println(BitwiseOne(strings));

        String[] strings1 = {"00011", "01010"};
        System.out.println(BitwiseOne(strings1));
    }

}