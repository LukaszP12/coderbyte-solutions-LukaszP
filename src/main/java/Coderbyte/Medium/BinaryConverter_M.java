package Coderbyte.Medium;

public class BinaryConverter_M {

    public static int BinaryConverter_M(String str) {

        char[] binaries = str.toCharArray();
        int result = 0;
        int powCounter = 0;

        for (int i = binaries.length - 1; i >= 0; i--) {

            if (binaries[i] == '1') {
                result += (int) Math.pow(2, powCounter);
            }
            powCounter++;
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(BinaryConverter_M("100101"));
        System.out.println(BinaryConverter_M("011"));
        System.out.println(BinaryConverter_M("101"));
        System.out.println(BinaryConverter_M("1000"));
    }

}