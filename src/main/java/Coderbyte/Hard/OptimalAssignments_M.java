package Coderbyte.Hard;

public class OptimalAssignments_M {

    static int min = Integer.MAX_VALUE;

    static String stringResult = "";

    public static String OptimalAssignments_M(String[] strArr) {

        int[][] matrix = toMatrix(strArr);

        boolean[] visited = new boolean[strArr.length];

        explore(matrix, visited, "", 0, 0);

        return stringResult;
    }

    private static void explore(int[][] matrix, boolean[] visited, String result, int sum, int level) {

        if (level == matrix.length) {
            if (sum < min) {
                min = sum;
                stringResult = result;
            }
        }

        for (int i = 0; i < matrix.length; i++) {
            if (!visited[i]) {
                visited[i] = true;
                explore(matrix, visited, result + "(" + (level + 1) + "-" + (i + 1) + ")", sum + matrix[level][i], level + 1);
                visited[i] = false;
            }
        }

    }

    public static int[][] toMatrix(String[] strArr) {

        int[][] newArray = new int[strArr.length][strArr.length];

        for (int i = 0; i < strArr.length; i++) {
            String[] split = strArr[i].substring(1, strArr[i].length() - 1).split(",");
            for (int j = 0; j < strArr.length; j++) {
                newArray[i][j] = Integer.parseInt(split[j]);
            }
        }

        return newArray;
    }

    public static void main(String[] args) {
//        String[] strings = {"(1,2,1)", "(4,1,5)", "(5,2,1)"};
//        System.out.println(OptimalAssignments_M(strings));

        // incorrect cases

//        String[] strings1 = {"(13,4,7,6)", "(1,11,5,4)", "(6,7,2,8)", "(1,3,5,9)"};
//        System.out.println(OptimalAssignments_M(strings1));

        String[] strings2 = {"(5,4,2)", "(12,4,3)", "(3,4,13)"};
        System.out.println(OptimalAssignments_M(strings2));
    }

}