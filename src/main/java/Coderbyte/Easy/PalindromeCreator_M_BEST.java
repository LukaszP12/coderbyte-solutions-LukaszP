package Coderbyte.Easy;

public class PalindromeCreator_M_BEST {

    public static String PalindromeCreator(String str) {
        if (str.length() < 3) {
            return "not possible";
        }

        if (isPalindrome(str)) {
            return "palindrome";
        }

        for (int i = 0; i < str.length(); i++) {
            String oneRemoved = new StringBuilder(str).deleteCharAt(i).toString();
            if (isPalindrome(oneRemoved)) {
                return "" + str.charAt(i);
            }
        }

        for (int i = 0; i < str.length(); i++) {
            String oneRemoved = new StringBuilder(str).deleteCharAt(i).toString();
            if (isPalindrome(oneRemoved)) {
                return "" + str.charAt(i);
            }

            for (int j = 0; j < oneRemoved.length(); j++) {
                String secondRemoved = new StringBuilder(oneRemoved).deleteCharAt(j).toString();
                if (isPalindrome(secondRemoved)) {
                    return "" + str.charAt(i) + oneRemoved.charAt(j);
                }
            }
        }


        return "not possible";
    }

    private static boolean isPalindrome(String str) {

        if (str.length() < 3) {
            return false;
        }

        for (int i = 0; i < str.length() / 2; i++) {
            if (str.charAt(i) != str.charAt(str.length() - 1 - i)) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        String mmop = "mmop";
        System.out.println(PalindromeCreator(mmop));

        String kjjjhjjj = "kjjjhjjj";
        System.out.println(PalindromeCreator(kjjjhjjj));

        String kayakb = "kayakb";
        System.out.println(PalindromeCreator(kayakb));

        String aaabaaaj = "aaabaaaj";
        System.out.println(PalindromeCreator(aaabaaaj));

        String annak = "annak";
        System.out.println(PalindromeCreator(annak));
    }

}