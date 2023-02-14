package Coderbyte.Hard;

public class MatchingCouples_M {

//    [B, G, N] where B represents the number of boys,
//    G represents the number of girls,
//    and N represents how many people you want to pair together.

    public static int MatchingCouples_2(int[] arr) {
        int numBoys = arr[0];
        int numGirls = arr[1];
        int peopleToPair = arr[2];

        int pairComb = 1;
        for (int i = peopleToPair / 2; i > 1; i--) {
            pairComb *= i;
        }

        return noRepeats(numBoys, peopleToPair / 2) * noRepeats(numGirls, peopleToPair / 2) * pairComb;
    }

    public static int noRepeats(int total, int elem) {

        int upper = 1;

        for (int i = total; i > total - elem; i--) {
            upper *= i;
        }

        int low = fact(elem);

        return upper / low;
    }

    private static int fact(int elem) {
        int result = 1;

        for (int i = elem; i > 0; i--) {
            result *= i;
        }

        return result;
    }

    public static void main(String[] args) {
        int[] ints = {5, 5, 4};
        System.out.println(MatchingCouples_2(ints));
        int[] ints1 = {2, 2, 2};
        System.out.println(MatchingCouples_2(ints1));
        int[] ints2 = {5, 3, 2};
        System.out.println(MatchingCouples_2(ints2));
        int[] ints3 = {10, 5, 4};
        System.out.println(MatchingCouples_2(ints3));

        int[] ints4 = {10, 10, 6};
        System.out.println(MatchingCouples_2(ints4));

        int[] ints5 = {15, 10, 6};
        System.out.println(MatchingCouples_2(ints5));
    }

}