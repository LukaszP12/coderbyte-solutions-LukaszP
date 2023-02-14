package Coderbyte.Medium;

public class EightQueens_M {

    public static String EightQueens_M(String[] strArr) {
        int[][] queens = new int[8][2];

        int i = 0;
        for (String s : strArr) {
            String[] split = s.replaceAll("[^0-9,]", "").split(",");
            queens[i][0] = Integer.parseInt(split[0]);
            queens[i][1] = Integer.parseInt(split[1]);
            i++;
        }


        for (int j = 0; j < queens.length; j++) {
            for (int k = 1; k < queens.length; k++) {
                if (j != k && queens[j][0] == queens[k][0]) {
                    return "(" + queens[j][0] + "," + queens[j][1] + ")";
                }

                if (j != k && queens[j][1] == queens[k][1]) {
                    return "(" + queens[j][0] + "," + queens[j][1] + ")";
                }

                int distanceX = Math.abs(queens[j][0] - queens[k][0]);
                int distanceY = Math.abs(queens[j][1] - queens[k][1]);

                if (j != k && distanceX == distanceY) {
                    return "(" + queens[j][0] + "," + queens[j][1] + ")";
                }

            }
        }

        return "true";
    }

    public static void main(String[] args) {
        String[] strings = {"(2,1)", "(4,3)", "(6,3)", "(8,4)", "(3,4)", "(1,6)", "(7,7)", "(5,8)"};
        System.out.println(EightQueens_M(strings));

        String[] strings1 = {"(2,1)", "(5,3)", "(6,3)", "(8,4)", "(3,4)", "(1,8)", "(7,7)", "(5,8)"};
        System.out.println(EightQueens_M(strings1));

        String[] strings2 = {"(2,1)", "(4,2)", "(6,3)", "(8,4)", "(3,5)", "(1,6)", "(7,7)", "(5,8)"};
        System.out.println(EightQueens_M(strings2));
    }

}
