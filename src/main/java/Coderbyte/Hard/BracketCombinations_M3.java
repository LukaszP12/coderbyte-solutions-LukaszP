package Coderbyte.Hard;

public class BracketCombinations_M3 {

    static int counter = 0;

    public static int BracketCombinations_M3(int num) {

        explore("", num, 0);

        return counter;
    }

    public static void explore(String result, int left, int right) {

        if (left == 0 && right == 0) {
            counter++;
            return;
        }

        if (left > 0) {
            explore(result + "(", left - 1, right + 1);
        }

        if (right > 0) {
            explore(result + ")", left, right - 1);
        }

    }

    public static void main(String[] args) {
//        System.out.println(BracketCombinations_M3(2));
        System.out.println(BracketCombinations_M3(3));
    }

}
