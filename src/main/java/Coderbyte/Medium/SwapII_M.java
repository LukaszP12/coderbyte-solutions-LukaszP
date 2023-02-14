package Coderbyte.Medium;

public class SwapII_M {

    public static String SwapII(String str) {
        String result = "";
        boolean firstDigit = false;
        int firstDigitIndex = 0;
        boolean secondDigit = false;
        int secondDigitIndex = 0;

        for (int i = 0; i < str.length(); i++) {
            char charAt = str.charAt(i);

            if (!firstDigit && Character.isLetter(charAt)) {
                result += swapCase(charAt);
            } else if (!firstDigit && !Character.isLetterOrDigit(charAt)) {
                result += charAt;
            }

            if (firstDigit && Character.isWhitespace(charAt)) {
                result += str.substring(firstDigitIndex, i + 1);

                firstDigit = false;
                firstDigitIndex = 0;
            }

            if (!firstDigit && Character.isDigit(charAt)) {
                firstDigit = true;
                firstDigitIndex = i;
            } else if (firstDigit && Character.isDigit(charAt)) {
                secondDigit = true;
                secondDigitIndex = i;
            }

            if (firstDigit && secondDigit && str.substring(firstDigitIndex + 1, secondDigitIndex).matches(".\\w+.")) {
                result += str.charAt(secondDigitIndex);

                String substring = str.substring(firstDigitIndex + 1, secondDigitIndex);
                for (int j = 0; j < substring.length(); j++) {
                    if (Character.isLetter(substring.charAt(j))) {
                        result += "" + swapCase(substring.charAt(j));
                    } else {
                        result += "" + substring.charAt(j);
                    }

                }

                result += str.charAt(firstDigitIndex);

                firstDigit = false;
                firstDigitIndex = 0;
                secondDigit = false;
                secondDigitIndex = 0;
            }

        }

        return result;
    }

    private static char swapCase(char c) {
        if (Character.isLowerCase(c)) {
            return Character.toUpperCase(c);
        } else {
            return Character.toLowerCase(c);
        }
    }

    public static void main(String[] args) {
        String l3OV2E = "L3OV2E";
        System.out.println(SwapII(l3OV2E));

        String s3 = "Hel4lo2 World";
        System.out.println(SwapII(s3));

        String s = "Hello -5LOL6";
        System.out.println(SwapII(s));

        // incorrect cases
        String s1 = "2S 6 du5d4e";
        System.out.println(SwapII(s1));

        String s2 = "123gg))((";
        System.out.println(SwapII(s2));
    }

}
