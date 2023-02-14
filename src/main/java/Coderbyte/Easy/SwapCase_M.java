package Coderbyte.Easy;

public class SwapCase_M {

    public static String SwapCase(String str) {
        String result = "";

        for (int i = 0; i < str.length(); i++) {

            if (Character.isUpperCase(str.charAt(i))) {
                result += Character.toLowerCase(str.charAt(i));
            } else if (Character.isLowerCase(str.charAt(i))) {
                result += Character.toUpperCase(str.charAt(i));
            } else {
                result += str.charAt(i);
            }

        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(SwapCase("Hello-LOL"));
        System.out.println(SwapCase("Sup DUDE!!?"));
    }

}