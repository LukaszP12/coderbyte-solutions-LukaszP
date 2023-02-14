package Coderbyte.Medium;

public class ArrayMinJumps_M {

    static int minCounter = Integer.MAX_VALUE;

    public static int ArrayMinJumps_2M(int[] strArr) {

        int counter = 0;

        minJumps(strArr, 0, counter);
        return (minCounter == Integer.MAX_VALUE) ? -1 : minCounter;
    }

    private static void minJumps(int[] strArr, int i, int counter) {

        if (i >= strArr.length - 1) {

            if (counter < minCounter) {
                minCounter = counter;
            }
            return;
        }

        for (int j = i + 1; j <= i + strArr[i]; ++j) {
            minJumps(strArr, j, counter + 1);
        }

    }

    public static void main(String[] args) {
        int[] ints = {1, 5, 4, 6, 9, 3, 0, 0, 1, 3};
        System.out.println(ArrayMinJumps_2M(ints));

        int[] ints1 = {3, 4, 2, 1, 1, 100};
        System.out.println(ArrayMinJumps_2M(ints1));

        int[] ints2 = {1, 5, 4, 6, 9, 3, 0, 0, 1, 3};
        System.out.println(ArrayMinJumps_2M(ints2));

        int[] ints3 = {1, 3, 6, 8, 2, 7, 1, 2, 1, 2, 6, 1, 2, 1, 2};
        System.out.println(ArrayMinJumps_2M(ints3));
    }

}
