package Coderbyte.Hard;

public class MaximalSquare_M {

    public static int MaximalSquare_M(String[] strArr) {
        int rows = strArr.length;
        int cols = strArr[0].length();

        int result = 0;

        int diff = 0;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {

                while (i + diff < rows && j + diff < cols) {
                    if (hasOnlyOnes(strArr, i, j, diff)) {
                        int field = (diff + 1) * (diff + 1);
                        if (result < field) {
                            result = field;
                        }
                    } else {
                        diff = 0;
                        break;
                    }
                    diff++;
                }

            }
        }

        return result;
    }

    private static boolean hasOnlyOnes(String[] strArr, int i, int j, int diff) {

        for (int k = i; k <= i + diff; k++) {
            for (int l = j; l <= j + diff; l++) {
                if (strArr[k].charAt(l) != '1') {
                    return false;
                }
            }
        }

        return true;
    }

    public static void main(String[] args) {
        String[] strings = {"0111", "1111", "1111", "1111"};
        System.out.println(MaximalSquare_M(strings));

        String[] strings1 = {"0111", "1101", "0111"};
        System.out.println(MaximalSquare_M(strings1));
    }

}
