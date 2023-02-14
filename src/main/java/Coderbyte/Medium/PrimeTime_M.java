package Coderbyte.Medium;

import java.util.ArrayList;
import java.util.List;

public class PrimeTime_M {

    static List<Integer> primes = new ArrayList<Integer>();

    public static Boolean PrimeTime_M(int num) {

        if (num == 1 || num == 2 || num == 3 || num == 5) {
            return true;
        }

        for (int i = 1; i <= num; i++) {

            if (i == 1 || i == 2 || i == 3 || i == 5) {
                continue;
            } else if (i % 2 == 0) {
                continue;
            } else if (i % 3 == 0) {
                continue;
            } else if (i % 5 == 0) {
                continue;
            } else if (primes.isEmpty()) {
                primes.add(i);
            } else if (isNotDivByOtherPrime(i)) {
                primes.add(i);
            }

        }


        if (primes.contains(num)) {
            return true;
        }

        return false;
    }

    private static boolean isNotDivByOtherPrime(int i) {
        for (int prime : primes) {
            if (i % prime == 0) {
                return false;
            }
        }
        return true;
    }


    public static void main(String[] args) {
        System.out.println(PrimeTime_M(4));
        System.out.println(PrimeTime_M(1709));

        System.out.println(PrimeTime_M(289));
    }

}
