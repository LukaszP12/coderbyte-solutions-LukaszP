package Coderbyte.Hard;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ApproachingFibonacci_M {

    public static int ApproachingFibonacci(int[] arr) {

        int sum = Arrays.stream(arr).sum();

        int nextFib = findNextFib(sum);

        return nextFib - sum;
    }

    private static int findNextFib(int sum) {
        List<Integer> fibNumbers = new ArrayList<>();

        fibNumbers.add(0);
        fibNumbers.add(1);

        while (true) {

            int i1 = fibNumbers.get(fibNumbers.size() - 2);
            int i2 = fibNumbers.get(fibNumbers.size() - 1);

            fibNumbers.add(i1 + i2);

            if (fibNumbers.get(fibNumbers.size() - 1) >= sum) {
                break;
            }
        }

        return fibNumbers.get(fibNumbers.size() - 1);
    }

    public static void main(String[] args) {
        int[] ints = {5, 2, 1};
        System.out.println(ApproachingFibonacci(ints));

        int[] ints1 = {1, 20, 2, 5};
        System.out.println(ApproachingFibonacci(ints1));
    }

}
