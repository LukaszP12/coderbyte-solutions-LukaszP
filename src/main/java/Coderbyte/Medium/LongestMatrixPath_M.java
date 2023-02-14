package Coderbyte.Medium;

import java.util.HashSet;
import java.util.Set;

public class LongestMatrixPath_M {

    static int longestPath = 0;

    public static int LongestMatrixPath_M(String[] strArr) {
        int rows = strArr.length;
        int cols = strArr[0].length();

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                boolean[][] isVisited = new boolean[rows][cols];
                int prev = -1;
                Set<Integer> set = new HashSet<>();
                checkPath(strArr, i, j, prev, isVisited, set);
            }
        }

        return longestPath - 1;
    }

    private static void checkPath(String[] strArr, int i, int j, int prev, boolean[][] isVisited, Set<Integer> set) {

        if (i < 0 || j < 0 || i >= strArr.length || j >= strArr[0].length() || isVisited[i][j]) {
            return;
        } else {
            int numPos = Integer.parseInt("" + strArr[i].charAt(j));
            isVisited[i][j] = true;

            if (!set.contains(numPos) && numPos > prev) {
                set.add(numPos);
                prev = numPos;

                if (set.size() > longestPath) {
                    longestPath = set.size();
                }

            }
        }

        int[] waysX = {1, 0, -1, 0};
        int[] waysY = {0, 1, 0, -1};

        for (int k = 0; k < waysX.length; k++) {
            checkPath(strArr, i + waysY[k], j + waysX[k], prev, isVisited, set);
        }

    }


    public static void main(String[] args) {
//        String[] strings = {"12256", "56219", "43215"};
//        System.out.println(LongestMatrixPath_M(strings));

//        String[] strings1 = {"67", "21", "45"};
//        System.out.println(LongestMatrixPath_M(strings1));

//        String[] strings2 = {"345", "326", "221"};
//        System.out.println(LongestMatrixPath_M(strings2));

//        String[] strings3 = {"111", "111", "111"};
//        System.out.println(LongestMatrixPath_M(strings3));

        // incorrect cases
//        String[] strings5 = {"12256", "56219", "43215"};
//        System.out.println(LongestMatrixPath_M(strings5));

        // 12256
        // 56219
        // 43215

//        String[] strings6 = {"564215", "287532", "193167", "111123"};
//        System.out.println(LongestMatrixPath_M(strings6));

//        String[] strings7 = {"9452124643115673264"};
//        System.out.println(LongestMatrixPath_M(strings7));
    }

}