package Coderbyte.Medium;

public class TrappingWater_M {

    public static int TrappingWater_M(int[] arr) {

        int result = 0;

        int left[] = new int[arr.length];
        int right[] = new int[arr.length];

        int maxL = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > maxL) {
                maxL = arr[i];
            }
            left[i] = maxL;
        }

        int maxR = 0;
        for (int i = arr.length - 1; i >= 0; i--) {
            if (arr[i] > maxR) {
                maxR = arr[i];
            }
            right[i] = maxR;
        }

        for (int i = 0; i < arr.length; i++) {
            result += Math.min(left[i], right[i]) - arr[i];
        }

        return result;
    }

    public static void main(String[] args) {
        int[] ints = {1, 2, 1, 2};
        System.out.println(TrappingWater_M(ints));

        int[] ints1 = {0, 2, 4, 0, 2, 1, 2, 6};
        System.out.println(TrappingWater_M(ints1));

        int[] ints2 = {4, 3, 2, 1};
        System.out.println(TrappingWater_M(ints2));
    }

}