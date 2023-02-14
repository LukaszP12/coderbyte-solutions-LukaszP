package Coderbyte.Medium;

public class MaxSubarray_M {

    public static int MaxSubarray_M(int[] arr) {

        int max_sum = Integer.MIN_VALUE;

        for (int i = 0; i < arr.length; i++) {
            int sum = 0;
            for (int j = i; j < arr.length; j++) {
                sum += arr[j];
                if (sum > max_sum) {
                    max_sum = sum;
                }
            }
        }

        return max_sum;
    }

    public static void main(String[] args) {
        int[] ints = {1, -2, 0, 3};
        System.out.println(MaxSubarray_M(ints));

        int[] ints1 = {3, -1, -1, 4, 3, -1};
        System.out.println(MaxSubarray_M(ints1));
    }

}
