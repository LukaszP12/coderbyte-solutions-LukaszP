package Coderbyte.Hard;

public class QueenCheck_M2 {

    public static int QueenCheck_M2(String[] strArr) {
        int queenX = Integer.parseInt(strArr[0].substring(1, 2));
        int queenY = Integer.parseInt(strArr[0].substring(3, 4));

        int kingX = Integer.parseInt(strArr[1].substring(1, 2));
        int kingY = Integer.parseInt(strArr[1].substring(3, 4));

        int counter = 0;

        if (isInCheck(kingX, kingY, queenX, queenY)) {

            for (int i = kingX - 1; i <= kingX + 1; i++) {
                for (int j = kingY - 1; j <= kingY + 1; j++) {

                    if (!isInCheck(i, j, queenX, queenY) && (i >= 1 && i <= 8 && j >= 1 && j <= 8)) {
                        counter++;
                    } else if (i == queenX && j == queenY) {
                        counter++;
                    }

                }
            }

        }

        return counter == 0 ? -1 : counter;
    }

    private static boolean isInCheck(int kingX, int kingY, int queenX, int queenY) {

        if (kingX == queenX || kingY == queenY) {
            return true;
        }

        return Math.abs(kingX - queenX) == Math.abs(kingY - queenY);
    }

    public static void main(String[] args) {
        String[] strings = {"(1,1)", "(1,4)"};
        System.out.println(QueenCheck_M2(strings));

        String[] strings1 = {"(3,1)", "(4,4)"};
        System.out.println(QueenCheck_M2(strings1));
    }

}