package Coderbyte.Hard;


public class AlphabetRunEncryption_M {

    public static String AlphabetRunEncryption_M(String str) {
        char[] chars = str.toCharArray();
        char savedLetter = '!';

        String result = "";

        int i = chars.length - 1;

        while (i > 0) {

            if (chars[i] == 'L') {
                // 1. left or right
                char rChar = chars[i - 1];
                savedLetter = (char) (rChar + 1);
                char c = (char) (rChar - 1);
                i -= 2;
                result += "" + c;
            } else if (chars[i] == 'R') {
                char lChar = chars[i - 1];
                savedLetter = (char) (lChar - 1);
                char c1 = (char) (lChar + 1);
                i -= 2;
                result += "" + c1;

                // 2. zero letter in between so S
            } else if (chars[i] == 'S') {
                result += chars[i - 1];
                savedLetter = chars[i - 2];
                i -= 3;
                // 3. repeated letters so N
            } else if (chars[i] == 'N') {
                result += chars[i - 1];
                savedLetter = '!';
                i -= 2;
            } else {

                int initDiff = chars[i] - chars[i - 1];
                char aChar = chars[i];
                char bChar = chars[i - 1];

                while (true) {
                    if (i < 1) {
                        break;
                    }

                    int diff = chars[i] - chars[i - 1];

                    if (diff != initDiff) {
                        break;
                    }

                    bChar = (char) (bChar - diff);

                    i--;
                }

                result += ((char) (aChar - 1)) + "" + (bChar);
            }
        }

        if (savedLetter != '!') {
            result += savedLetter;
        }

        return new StringBuilder(result).reverse().toString();
    }


    public static void main(String[] args) {
        String s1 = "bcdefghijklmnopqrstN";
        System.out.println(AlphabetRunEncryption_M(s1));

        String s2 = "abSbaSaNbR";
        System.out.println(AlphabetRunEncryption_M(s2));

        String s4 = "cdef";
        System.out.println(AlphabetRunEncryption_M(s4));

        String s5 = "defghijklmno";
        System.out.println(AlphabetRunEncryption_M(s5));

        String s6 = "abSbaS";
        System.out.println(AlphabetRunEncryption_M(s6));

        String s7 = "abSbNcR";
        System.out.println(AlphabetRunEncryption_M(s7));

        // incorrect cases
        String s3 = "defghijklmnnmlkjihgfedeS";
        System.out.println(AlphabetRunEncryption_M(s3));

        String s8 = "cdefghijklmnopqrstuvwxxwvusrqponmlkjihgf";
        System.out.println(AlphabetRunEncryption_M(s8));

        String s9 = "baSbcdefghijklmnopqrstNtNtNtsS";
        System.out.println(AlphabetRunEncryption_M(s9));

        String s10 = "baSaNabScdefghijklmnop";
        System.out.println(AlphabetRunEncryption_M(s10));
    }

}