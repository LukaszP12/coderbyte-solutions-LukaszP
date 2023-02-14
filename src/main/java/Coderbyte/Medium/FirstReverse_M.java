package Coderbyte.Medium;

public class FirstReverse_M {

    public static String FirstReverse_M(String str) {
        // code goes here

        String result = "";

        for (int i = 1; i <= str.length(); i++) {
            result += str.charAt(str.length() - i);
        }

        return result;
    }


    public static void main(String[] args) {
        String coderbyte = "coderbyte";
        System.out.println(FirstReverse_M(coderbyte));

        String s = "I Love Code";
        System.out.println(FirstReverse_M(s));
    }

}
