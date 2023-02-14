package Coderbyte.Easy;

public class FirstFactorial_M {

    public static int FirstFactorial_M(int num) {
        int product = 1;

        for (int i = 1; i <= num; i++) {
            product *= i;
        }

        return product;
    }

    public static void main(String[] args) {
        System.out.println(FirstFactorial_M(4));
        System.out.println(FirstFactorial_M(8));
    }

}