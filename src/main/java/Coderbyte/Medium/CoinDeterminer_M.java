package Coderbyte.Medium;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class CoinDeterminer_M {
    static int min = Integer.MAX_VALUE;

    public static int CoinDeterminer_M(int num) {
        List<Integer> allCoins = Arrays.asList(11, 9, 7, 5, 1);
        int counter = 0;

        if (allCoins.contains(num)) {
            return 1;
        }

        coinCounter(allCoins, counter, num);

        return min;
    }

    public static void coinCounter(List<Integer> coins, int counter, int num) {

        if (num < 0) {
            return;
        }

        if (num == 0) {
            if (counter < min) {
                min = counter;
            }
            return;
        }

        int finalNum = num;
        List<Integer> list = coins.stream().filter(x -> x <= finalNum).sorted().collect(Collectors.toList());

        for (int l : list) {
            coinCounter(list, counter + 1, num - l);
        }

    }

    public static void main(String[] args) {
//        System.out.println(CoinDeterminer_M(6));
//        System.out.println(CoinDeterminer_M(16));
//        System.out.println(CoinDeterminer_M(2));
//        System.out.println(CoinDeterminer_M(34));

        // incorrect
        System.out.println(CoinDeterminer_M(100));

    }

}