package Coderbyte.Medium;

public class OffBinary_M {

    public static int OffBinary_M(String[] strArr) {
        int firstNumber = Integer.parseInt(strArr[0]);
        String binaryFirst = DecimalToBinary(firstNumber);

        return compareBinaries(binaryFirst, strArr[1]);
    }

    private static int compareBinaries(String binaryFirst, String s) {
        char[] charArray1 = binaryFirst.toCharArray();
        char[] charArray2 = s.toCharArray();

        int length = charArray1.length > charArray2.length ? charArray1.length : charArray2.length;
        int counter = 0;

        for (int i = 0; i < length; i++) {
            if (charArray1[i] != charArray2[i]) {
                counter++;
            }
        }

        counter += charArray1.length - length + charArray2.length - length;

        return counter;
    }

    private static String DecimalToBinary(int num) {

        String result = "";

        while (num > 0) {
            if (num % 2 == 0) {
                result += "0";
            } else {
                result += "1";
            }
            num = num / 2;
        }

        return new StringBuilder(result).reverse().toString();
    }

    public static void main(String[] args) {
        String[] strings = {"5624", "0010111111001"};
        System.out.println(OffBinary_M(strings));

        String[] strings1 = {"44", "111111"};
        System.out.println(OffBinary_M(strings1));
    }

}