package Coderbyte.Easy;

import java.util.Arrays;

public class MeanMode_M {

    public static int MeanMode(int[] arr) {
//        mean
        int sum = Arrays.stream(arr).sum();
        int length = arr.length;

        int mean = sum / length;

//        mode - mediana
        int mode = getMode(arr);

        if (mean == mode) {
            return 1;
        }

        return 0;
    }

    private static int getMode(int[] arr) {
        Arrays.sort(arr);

        int max_counter = 0;

        int mode_number = 0;
        int counter = 1;

        for (int i = 1; i < arr.length; i++) {
            if (arr[i - 1] != arr[i]) {
                counter = 1;
            }

            if (arr[i - 1] == arr[i]) {
                counter++;
                if (counter > max_counter) {
                    max_counter = counter;
                    mode_number = arr[i];
                }
            }

        }

        return mode_number;
    }

    public static void main(String[] args) {
        int[] ints = {1, 2, 3};
        System.out.println(MeanMode(ints));

        int[] ints1 = {4, 4, 4, 6, 2};
        System.out.println(MeanMode(ints1));
    }

}
