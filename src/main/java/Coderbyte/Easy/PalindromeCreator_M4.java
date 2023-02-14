package Coderbyte.Easy;

public class PalindromeCreator_M4 {

    public static String PalindromeCreator_M4(String str) {

        if (str.length() < 3) {
            return "not possible";
        }

        if (isPalindrome(str)) {
            return "palindrome";
        }

        String removedChars = "";

        int initLength = str.length();

        for (int i = 0; i < initLength; i++) {
            String newString = str.substring(0, i) + str.substring(i, i) + str.substring(i + 1);
            int newLength = newString.length();

            if (newString.length() > 2 && isPalindrome(newString)) {
                removedChars += "" + str.charAt(i);
                return removedChars;
            }

        }

        for (int i = 0; i < initLength; i++) {
            String newString = str.substring(0, i) + str.substring(i, i) + str.substring(i + 1);
            int newLength = newString.length();

            if (newString.length() > 2 && isPalindrome(newString)) {
                removedChars += "" + str.charAt(i);
                return removedChars;
            }

            for (int j = 0; j < newLength; j++) {

                String secondString = newString.substring(0, j) + newString.substring(j, j) + newString.substring(j + 1);
                if (secondString.length() > 2 && isPalindrome(secondString)) {
                    removedChars += "" + str.charAt(i) + newString.charAt(j);
                    return removedChars;
                }

            }

        }


        return "not possible";
    }

    private static boolean isPalindrome(String str) {
        int length = str.length();

        for (int i = 0; i < str.length() / 2; i++) {
            if (str.charAt(i) != str.charAt(length - 1 - i)) {
                return false;
            }
        }

        return true;
    }


    public static void main(String[] args) {
//        System.out.println(PalindromeCreator_M4("mmop"));
//        System.out.println(PalindromeCreator_M4("kjjjhjjj"));
//        System.out.println(PalindromeCreator_M4("abjchba"));

        System.out.println(PalindromeCreator_M4("aaabaaaj"));

//        String str1 = "aaabaaaj";
//        int i = str1.length() - 1;
//
//        String s = str1.substring(0, i) + str1.substring(i, i) + str1.substring(i + 1);
//        System.out.println(s);
//
//        System.out.println(isPalindrome(s));
//        System.out.println(str1.charAt(i));
    }

}
