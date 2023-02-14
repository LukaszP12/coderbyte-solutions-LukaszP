package Coderbyte.Easy;

public class LargestPair_M {

    public static int LargestPair(String num) {
        int max = 0;

//        char[] chars = String.valueOf(num).toCharArray();
        char[] chars = num.toCharArray();

        for (int i = 1; i < chars.length; i++) {
            int next_sum = Integer.parseInt(chars[i - 1] + "" + chars[i]);
            if (next_sum > max) {
                max = next_sum;
            }
        }

        return max;
    }

    public static void main(String[] args) {
        System.out.println(LargestPair("453857"));
        System.out.println(LargestPair("363223311"));

        // incorrect
        System.out.println(LargestPair("5673536634"));
    }

}
