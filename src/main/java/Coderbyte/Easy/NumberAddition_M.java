package Coderbyte.Easy;

public class NumberAddition_M {

    public static int NumberAddition(String str) {

        int sum = 0;

        char[] charArray = str.toCharArray();

        String currentNumber = "";

        char prev = str.charAt(0);

        for (int i = 0; i < charArray.length; i++) {

            if (Character.isDigit(charArray[i])) {
                currentNumber += "" + charArray[i];
                prev = charArray[i];
                continue;
            }

            if (!Character.isDigit(charArray[i]) && Character.isDigit(prev)) {
                sum += Integer.parseInt(currentNumber);
                currentNumber = "";
                prev = charArray[i];
            }

        }


        if (currentNumber.length() > 0) {
            sum += Integer.parseInt(currentNumber);
        }

        return sum;
    }


    public static void main(String[] args) {
        String s = "75Number9";
        System.out.println(NumberAddition(s));

        String s1 = "10 2One Number*1*";
//        System.out.println(NumberAddition(s1));

        // incorrect cases
        String s2 = "1 2 3 4 k10";
        System.out.println(NumberAddition(s2));

        String s3 = "One12 12";
        System.out.println(NumberAddition(s3));

//        System.out.println("12".length() > 0);
    }

}