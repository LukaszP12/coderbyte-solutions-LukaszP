package Coderbyte.Medium;

public class MatrixChains_M {

    static int min = Integer.MAX_VALUE;

    public static int MatrixChains_M(int[] arr) {
        explore(arr, 0);

        return min;
    }

    private static void explore(int[] arr, int result) {

        for (int j = 1; j < arr.length - 1; j++) {
            result += arr[j - 1] * arr[j] * arr[j + 1];

            if (result > min) {
                return;
            }

            if (arr.length == 3) {

                if (result < min) {
//                    System.out.println("1: " + arr[j - 1]);
//                    System.out.println("2: " + arr[j]);
//                    System.out.println("3: " + arr[j + 1]);
                    min = result;
                }
                return;
            }

            int[] nextArray = createNextArray(arr, j);
            explore(nextArray, result);
            result -= arr[j - 1] * arr[j] * arr[j + 1];
        }

    }

    private static int[] createNextArray(int[] arr, int j) {
        int[] ints = new int[arr.length - 1];

        int k = 0;
        for (int i = 0; i < arr.length; i++) {

            if (i == j) {
                continue;
            }
            ints[k] = arr[i];
            k++;
        }

        return ints;
    }

    public static void main(String[] args) {
//        int[] ints = {2, 3, 4};
//        System.out.println(MatrixChains_M(ints));

//        int[] ints1 = {1, 4, 5, 6, 8};
//        System.out.println(MatrixChains_M(ints1));

//        int[] ints2 = {1, 2, 3, 4, 5, 6, 7, 8, 9, 20, 25, 30, 50, 60, 61, 61, 62};
//        System.out.println(MatrixChains_M(ints2));

        // incorrect cases
//        int[] ints3 = {10, 20, 100, 5, 4, 6, 9, 1, 2, 3, 5, 10, 9, 71};
//        System.out.println(MatrixChains_M(ints3));

        int[] ints4 = {5, 6, 7, 8, 9, 1, 1, 1, 2};
        System.out.println(MatrixChains_M(ints4));
    }


}