package Coderbyte.Medium;

public class BinaryTreeLCA_M {

    public static int BinaryTreeLCA_M(String[] strArr) {
        String s = strArr[0].replaceAll("[^0-9,#]", "");
        String[] split = s.split(",");

        int num1 = Integer.parseInt(strArr[1]);
        int num2 = Integer.parseInt(strArr[2]);

        int higher = Math.max(num1, num2);
        int lower = Math.min(num1, num2);

        for (String spl : split) {
            int i = Integer.parseInt(spl);

            if (i >= lower && i <= higher) {
                return i;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        String[] strings = {"[5, 2, 6, 1, #, 8, #]", "2", "6"};
        System.out.println(BinaryTreeLCA_M(strings));

        String[] strings1 = {"[10, 5, 1, 7, 40, 50]", "5", "10"};
        System.out.println(BinaryTreeLCA_M(strings1));

        String[] strings2 = {"[3, 2, 1, 12, 4, 5, 13]", "5", "13"};
        System.out.println(BinaryTreeLCA_M(strings2));
    }

}