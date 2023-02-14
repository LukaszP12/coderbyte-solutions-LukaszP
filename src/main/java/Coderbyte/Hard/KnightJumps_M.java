package Coderbyte.Hard;

public class KnightJumps_M {

    static int[][] knightMoves = {
            {1, 2},
            {-1, 2},
            {2, 1},
            {2, -1},
            {1, -2},
            {-1, -2},
            {-2, -1},
            {-2, 1}
    };

    public static int KnightJumps(String str) {
        String s = str.replaceAll("[^0-9\\s]", "");
        String[] split = s.split("\\s");

        int startingX = Integer.parseInt(split[0]);
        int startingY = Integer.parseInt(split[1]);

        int possibleMoves = 0;

        for (int i = 0; i < knightMoves.length; i++) {

            int x = knightMoves[i][0];
            int y = knightMoves[i][1];

            int moveX = startingX + x;
            int moveY = startingY + y;

            if (moveX > 0 && moveX < 9) {
                {
                    if (moveY > 0 && moveY < 9) {
                        possibleMoves++;
                    }
                }
            }

        }

        return possibleMoves;
    }

    public static void main(String[] args) {
        System.out.println(KnightJumps("(1 1)"));
        System.out.println(KnightJumps("(2 8)"));
    }

}