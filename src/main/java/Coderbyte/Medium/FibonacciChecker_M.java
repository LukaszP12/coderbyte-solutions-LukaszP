package Coderbyte.Medium;

import java.util.ArrayList;
import java.util.List;

public class FibonacciChecker_M {

    public static String FibonacciChecker_M(int num) {
        List<Integer> fibNumbers = new ArrayList<>();

        fibNumbers.add(0);
        fibNumbers.add(1);

        int n = 2;

        while (true) {
            fibNumbers.add(fibNumbers.get(n - 1) + fibNumbers.get(n - 2));
            if (fibNumbers.get(fibNumbers.size() - 1) == num) {
                return "yes";
            } else if (fibNumbers.get(fibNumbers.size() - 1) > num) {
                return "no";
            }

            n++;
        }

    }

    public static void main(String[] args) {
        System.out.println(FibonacciChecker_M(34));
        System.out.println(FibonacciChecker_M(54));
    }

}
