package Coderbyte.Easy;

public class HDistance_M {

    public static int HDistance(String[] strArr) {
        String firstString = strArr[0];
        String secondString = strArr[1];

        int counter = 0;

        for (int i = 0; i < firstString.length(); i++) {
            if (firstString.charAt(i) != secondString.charAt(i)) {
                counter++;
            }
        }

        return counter;
    }

    public static void main(String[] args) {
        String[] strings = {"10011", "10100"};
        System.out.println(HDistance(strings));

        String[] strings1 = {"abcdef", "defabc"};
        System.out.println(HDistance(strings1));
    }

}
