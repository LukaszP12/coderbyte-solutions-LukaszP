package Coderbyte.Medium;

public class NumberSearch_M {

    public static int NumberSearch4(String str) {
        String digits = str.replaceAll("\\D", "");
        String nonDigits = str.replaceAll("[^a-zA-Z]", "").replaceAll("\\s", "");

        char[] digitsArray = digits.toCharArray();
        double sum = 0;

        for (int i = 0; i < digitsArray.length; i++) {
            sum += (digitsArray[i] - 48);
        }

        return (int) Math.round(sum / nonDigits.length());
    }

    public static void main(String[] args) {
        String s = "H3ello9-9";
        System.out.println(NumberSearch4(s));

        String s1 = "One Number*1*";
        System.out.println(NumberSearch4(s1));

        // incorrect cases
        String s2 = "i love cake 9 8 7";
        System.out.println(NumberSearch4(s2));

        String s3 = "1p2ol5e ** 6";
        System.out.println(NumberSearch4(s3));
    }

}