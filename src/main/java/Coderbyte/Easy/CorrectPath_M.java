package Coderbyte.Easy;

public class CorrectPath_M {

    static String result = "-1";

    public static String CorrectPath_M(String str) {
        String[] movements = {"r", "l", "u", "d"};

        explorePaths(str, "", 0);


        return result;
    }

    private static void explorePaths(String str, String path, int index) {

        if (index == str.length() && canTravel(path)) {
            result = path;
            return;
        } else if (index == str.length()) {
            return;
        }

        char charAt = str.charAt(index);


        if (charAt == '?') {

            explorePaths(str, path + "r", index + 1);
            explorePaths(str, path + "l", index + 1);
            explorePaths(str, path + "u", index + 1);
            explorePaths(str, path + "d", index + 1);

        } else {
            explorePaths(str, path + "" + charAt, index + 1);
        }

    }

    private static boolean canTravel(String path) {
        int rows = 0;
        int cols = 0;

        boolean[][] visited = new boolean[10][10];

        for (int i = 0; i < path.length(); i++) {

            if (path.charAt(i) == 'd') {
                rows++;
            } else if (path.charAt(i) == 'u') {
                rows--;
            } else if (path.charAt(i) == 'r') {
                cols++;
            } else if (path.charAt(i) == 'l') {
                cols--;
            }

            if (rows > 4 || cols > 4) {
                return false;
            }


            if (rows > 0 && cols > 0) {

                if (visited[rows + 5][cols + 5]) {
                    return false;
                }
                visited[rows + 5][cols + 5] = true;
            } else {

                if (visited[Math.abs(rows)][Math.abs(cols)]) {
                    return false;
                }

                visited[Math.abs(rows)][Math.abs(cols)] = true;
            }

        }

        return (rows == 4) && (cols == 4);
    }

    public static void main(String[] args) {
//        String s = "???rrurdr?";
//        System.out.println(CorrectPath_M(s));

//        String s1 = "drdr??rrddd?";
//        System.out.println(CorrectPath_M(s1));

        String s2 = "rd?u??dld?ddrr";
        System.out.println(CorrectPath_M(s2));
    }

}