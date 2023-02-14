package Coderbyte.Hard;

public class SquareFigures {

    public static int SquareFigures(int num) {
        int init = 0;

        while (true) {
//            int squared = (int) Math.pow(init, 2);

            int newNumber = init * init;

            if (String.valueOf(newNumber).length() >= num) {
                break;
            }

            init++;
        }

        return init;
    }


    public static void main(String[] args) {
//        System.out.println(SquareFigures(2));
//        System.out.println(SquareFigures(1));
        System.out.println(SquareFigures(11));
    }

}
