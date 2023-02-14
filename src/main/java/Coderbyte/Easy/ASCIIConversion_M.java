package Coderbyte.Easy;

public class ASCIIConversion_M {

    public static String ASCIIConversion(String str) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            if (Character.isLetter(str.charAt(i))) {
                int asc = str.charAt(i);

                sb.append(asc + "");
            } else if (str.charAt(i) == ' ') {
                sb.append(' ');
            } else {
                int asc1 = str.charAt(i);
                sb.append(asc1 + "");
            }

        }

        return sb.toString();
    }

    public static void main(String[] args) {
        String helloWorld = "hello world";
        String s = "abc **";

        System.out.println(ASCIIConversion(helloWorld));
        System.out.println(ASCIIConversion(s));

        String s1 = "j*&@^";
        System.out.println(ASCIIConversion(s1));

        System.out.println(ASCIIConversion("<"));
    }
}
