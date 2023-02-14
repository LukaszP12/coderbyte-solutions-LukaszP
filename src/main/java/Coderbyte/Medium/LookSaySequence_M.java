package Coderbyte.Medium;

public class LookSaySequence_M {

    public static String LookSaySequence_M(int num) {
        String result = "";

        String number = String.valueOf(num);
        char numberAt = '0';

        int counter = 1;
        for (int i = 0; i < number.length(); i++) {
            numberAt = number.charAt(i);

            if (i < number.length() - 1 && numberAt == number.charAt(i + 1)) {
                counter++;
            }

            if (i < number.length() - 1 && numberAt != number.charAt(i + 1)) {
                result += counter + "" + numberAt;
                counter = 1;
            }

        }

        result += counter + "" + numberAt;

        return result;
    }


    public static void main(String[] args) {
        System.out.println(LookSaySequence_M(1211));
        System.out.println(LookSaySequence_M(2466));
    }

}