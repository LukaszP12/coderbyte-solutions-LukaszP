package Coderbyte.Medium;

public class ThreeFiveMultiples_M {

    public static int ThreeFiveMultiples_M(int num) {

        int sum = 0;

        for (int i = 3; i < num; i++) {
            if (i % 3 == 0 & i % 5 == 0) {
                sum += i;
            } else if (i % 3 == 0) {
                sum += i;
            } else if (i % 5 == 0) {
                sum += i;
            }

        }

        return sum;
    }

    public static void main(String[] args) {
        System.out.println(ThreeFiveMultiples_M(6));
        System.out.println(ThreeFiveMultiples_M(1));
    }

}