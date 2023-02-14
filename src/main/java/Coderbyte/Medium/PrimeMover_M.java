package Coderbyte.Medium;

import java.util.ArrayList;
import java.util.List;

public class PrimeMover_M {

    static List<Integer> primes = new ArrayList<>();

    public static int PrimeMover_M(int num) {

        primes.add(2);
        primes.add(3);
        primes.add(5);

        if (num <= 3) {
            return primes.get(num - 1);
        }

        int counter = 7;

        while (true) {

            generatePrimes(counter);
            if (primes.size() == num) {
                return primes.get(primes.size() - 1);
            }
            counter++;
        }

    }

    public static void generatePrimes(int num) {

        for (int i = 1; i <= num; i++) {

            if (i == 1 || i == 2 || i == 3) {
                continue;
            } else if (i % 2 == 0) {
                continue;
            } else if (i % 3 == 0) {
                continue;
            } else if (i % 5 == 0) {
                continue;
            } else if (isNotDivByOtherPrime(i)) {
                primes.add(i);
            }
        }

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
        System.out.println(PrimeMover_M(1));
        System.out.println(PrimeMover_M(9));
        System.out.println(PrimeMover_M(100));
    }

}