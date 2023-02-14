package Coderbyte.Medium;

import java.lang.reflect.Array;
import java.util.*;

public class PrimeChecker_M {

    static List<Integer> primes = new ArrayList<>();

    public static int PrimeChecker_M(int num) {

        if (String.valueOf(num).replaceAll("" + String.valueOf(num).charAt(0), "").length() == 0) {
            if (Primes(num)) {
                return 1;
            } else {
                return 0;
            }
        }

        Set<String> permutations = new HashSet<>();

        int length = String.valueOf(num).toCharArray().length;

        while (true) {
            String s = shuffle(num);
            permutations.add(s);

            if (permutations.size() == factorial(length)) {
                break;
            }
        }


        for (String s : permutations) {
            if (Primes(Integer.parseInt(s))) {
                return 1;
            }
        }


        return 0;
    }

    public static Boolean Primes(int num) {

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


    private static int factorial(int length) {

        int result = 1;

        for (int i = 1; i <= length; i++) {
            result *= i;
        }

        return result;
    }

    private static String shuffle(int num) {
        String s = String.valueOf(num);

        List<String> digits = Arrays.asList(s.split(""));
        Collections.shuffle(digits);

        String shuffled = "";

        for (String digit : digits) {
            shuffled += digit;
        }

        return shuffled;
    }


    public static void main(String[] args) {

        // incorrect results
        System.out.println(Primes(772));
        System.out.println(Primes(100));
    }

}