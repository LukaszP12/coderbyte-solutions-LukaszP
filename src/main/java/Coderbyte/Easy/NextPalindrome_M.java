package Coderbyte.Easy;

public class NextPalindrome_M {

    public static int NextPalindrome(int num) {

        while (true) {
            num++;
            if (isPalindrome(num)) {
                return num;
            }
        }

    }

    private static boolean isPalindrome(int num) {

        int i = Integer.parseInt(new StringBuilder("" + num).reverse().toString());

        if (num == i) {
            return true;
        }

        return false;
    }

    public static void main(String[] args) {
        System.out.println(NextPalindrome(2));
        System.out.println(NextPalindrome(180));
    }

}