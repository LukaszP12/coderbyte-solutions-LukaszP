package Coderbyte.Medium;

public class LargestRowColumn_M {

    static int maxPosition = 0;

    public static int LargestRowColumn_M(String[] strArr) {
        int rows = strArr.length;
        int cols = strArr[0].length();

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                boolean[][] isVisited = new boolean[rows][cols];
                explorePath(strArr, isVisited, i, j, 1, 0);
            }
        }

        return (maxPosition == 0) ? -1 : maxPosition;
    }


    private static void explorePath(String[] strArr, boolean[][] isVisited, int i, int j, int count, int sum) {

        if (i < 0 || j < 0 || i >= strArr.length || j >= strArr[0].length() || isVisited[i][j]) {
            return;
        } else {
            sum = sum + Integer.parseInt("" + strArr[i].charAt(j));

            isVisited[i][j] = true;

            if (count == 3) {
                String sumString = String.valueOf(sum);
                String[] split = sumString.split("");
                int num1 = Integer.parseInt(split[0]);
                int num2 = Integer.parseInt(split[split.length - 1]);

                if (num1 < strArr.length && num2 < strArr[0].length()) {

                    if (sum > maxPosition) {
                        maxPosition = sum;
                    }
                }

            }

        }

        int[] waysX = {1, 0, -1, 0};
        int[] waysY = {0, 1, 0, -1};

        for (int k = 0; k < waysX.length; k++) {
            explorePath(strArr, isVisited, i + waysY[k], j + waysX[k], count + 1, sum);
        }

    }


    public static void main(String[] args) {
//        String[] strings = {"234", "999", "999"};
//        System.out.println(LargestRowColumn_M(strings));
//
//        String[] strings2 = {"345", "326", "221"};
//        System.out.println(LargestRowColumn_M(strings2));
//
//        String[] strings5 = {"444", "511", "511"};
//        System.out.println(LargestRowColumn_M(strings5));
//


//                 incorrect cases
//        String[] strings3 = {"11111", "22222"};
//        System.out.println(LargestRowColumn_M(strings3));

//        String[] strings6 = {"11111"};
//        System.out.println(LargestRowColumn_M(strings6));

//        String[] strings4 = {"896", "161", "222", "333"};
//        System.out.println(LargestRowColumn_M(strings4));

        String[] strings7 = {"14567", "89123", "56711", "23456"};
        System.out.println(LargestRowColumn_M(strings7));
    }

}