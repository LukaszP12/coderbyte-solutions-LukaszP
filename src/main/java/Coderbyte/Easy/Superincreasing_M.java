package Coderbyte.Easy;


public class Superincreasing_M {

    public static boolean Superincreasing_M(int[] arr) {

        int currentSum = 0;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > currentSum) {
                currentSum += arr[i];
            } else {
                return false;
            }

        }

        return true;
    }

    public static void main(String[] args) {
        int[] ints = {1, 2, 3, 4};
        System.out.println(Superincreasing_M(ints));

        int[] ints1 = {1, 2, 5, 10};
        System.out.println(Superincreasing_M(ints1));
    }

}