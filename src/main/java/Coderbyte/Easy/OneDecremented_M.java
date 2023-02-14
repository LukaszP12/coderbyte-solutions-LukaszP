package Coderbyte.Easy;

public class OneDecremented_M {

    public static int OneDecremented(String str) {

        int counter = 0;

        for (int i = 1; i < str.length(); i++) {
            if ((str.charAt(i - 1) - 1) == (str.charAt(i))) {
                counter++;
            }
        }

        return counter;
    }

    public static void main(String[] args) {
        String s = "56";
        System.out.println(OneDecremented(s));

        String s1 = "9876541110";
        System.out.println(OneDecremented(s1));
    }
}
