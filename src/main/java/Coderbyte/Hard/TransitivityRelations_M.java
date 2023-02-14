package Coderbyte.Hard;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class TransitivityRelations_M {

    public static String TransitivityRelations_M(String[] strArr) {

        int[][] matrix = convertToArray(strArr);
        int length = matrix.length;

        boolean addedConn = true;
        // matrix transitivity
        // if a -> b && b -> c
        // then a -> c

        ArrayList<String> missing = new ArrayList<>();

        while (addedConn) {
            addedConn = false;
            for (int a = 0; a < length; a++) {
                for (int b = 0; b < length; b++) {
                    if (matrix[a][b] == 1) {
                        for (int c = 0; c < length; c++) {

                            if (matrix[b][c] == 1 && matrix[a][c] != 1 && a != c) {

                                if (matrix[b][c] == 1 && matrix[a][c] != 1) {

                                    missing.add("(" + a + "," + c + ")");
                                    matrix[a][c] = 1;
                                    addedConn = true;
                                }
                            }
                        }

                    }
                }
            }
        }

        String result = missing.stream().sorted().collect(Collectors.joining("-"));

        return missing.isEmpty() ? "transitive" : result;
    }

    private static int[][] convertToArray(String[] strArr) {

        int[][] array = new int[strArr.length][strArr.length];

        for (int i = 0; i < strArr.length; i++) {
            String[] split = strArr[i].substring(1, strArr[i].length() - 1).split(",");
            for (int j = 0; j < split.length; j++) {
                array[i][j] = Integer.parseInt(split[j]);
            }
        }

        return array;
    }

    public static void main(String[] args) {
        String[] strings = {"(1,1,1)", "(0,1,1)", "(0,1,1)"};
//        System.out.println(TransitivityRelations_M(strings));

//        String[] strings1 = {"(0,1,0,0)", "(0,0,1,0)", "(0,0,1,1)", "(0,0,0,1)"};
//        System.out.println(TransitivityRelations_M(strings1));
//
//        String[] strings2 = {"(1,1,1)", "(1,0,0)", "(0,1,0)"};
//        System.out.println(TransitivityRelations_M(strings2));

        // incorrect cases
        String[] strings3 = {"(1,1,0,0)", "(0,0,1,0)", "(0,1,0,1)", "(1,0,0,1)"};
        System.out.println(TransitivityRelations_M(strings3));
        // wrong order, should be (0,2)-(0,3)-(1,0)-(1,3)-(2,0)-(3,1)-(3,2)

        // incorrect cases
        String[] strings1 = {"(0,1,0,0)", "(0,0,1,0)", "(0,0,1,1)", "(0,0,0,1)"};
        System.out.println(TransitivityRelations_M(strings1));

        String[] strings2 = {"(1,1,1)", "(1,0,0)", "(0,1,0)"};
        System.out.println(TransitivityRelations_M(strings2));
    }

}