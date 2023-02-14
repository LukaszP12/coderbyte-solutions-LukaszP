package Coderbyte.Easy;

public class HammingDistance_M {

    public static int HammingDistance(String[] strArr) {
        String s = strArr[0];
        String s1 = strArr[1];

        int counter = 0;

        for (int i = 0; i < s.length(); i++) {

            if (s.charAt(i) != s1.charAt(i)) {
                counter++;
            }

        }

        return counter;
    }

    public static void main(String[] args) {
        String[] strings = {"10011", "10100"};
        System.out.println(HammingDistance(strings));

        String[] strings1 = {"helloworld", "worldhello"};
        System.out.println(HammingDistance(strings1));
    }

}