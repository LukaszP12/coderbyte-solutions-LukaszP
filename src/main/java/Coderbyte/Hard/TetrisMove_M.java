package Coderbyte.Hard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class TetrisMove_M {

    static int columnNum = 12;
    static int rowNum = 10;
    static HashMap<String, List<int[][]>> pieces;

    static int rowsFilledMax = 0;

    public static int TetrisMove_M(String[] strArr) {

        buildPiecesMap();

        String letter = strArr[0];
        List<int[][]> configurations = pieces.get(letter);

        List<int[]> board = toBoard(strArr, columnNum, rowNum);

        for (int i = 0; i < columnNum; i++) {
            for (int j = 0; j < rowNum; j++) {
                for (int[][] configuration : configurations) {
                    boolean found = true;

                    for (int[] c : configuration) {

                        if (!(i + c[0] >= 0 &&
                                i + c[0] < columnNum &&
                                j + c[1] >= 0 && j + c[1] < rowNum) ||
                                board.get(j + c[1])[i + c[0]] == 1) {
                            found = false;

                            break;
                        }
                    }

                    if (found) {
                        int rowsFilled = 0;
                        System.out.println("a possible configuration is found");

                        // toDo once found check how many rows are filled

                    }

                }
            }
        }


        // code goes here
        return rowsFilledMax;
    }

    private static void buildPiecesMap() {
        List<int[][]> ints = new ArrayList<>();
        pieces = new HashMap<>();

        ints = List.of(new int[][]{
                new int[]{0, 0},
                new int[]{0, 1},
                new int[]{0, 2},
                new int[]{0, 3}
        }, new int[][]{
                new int[]{0, 0},
                new int[]{1, 0},
                new int[]{2, 0},
                new int[]{3, 0}
        });

        pieces.put("I", ints);

        ints = List.of(new int[][]{
                        new int[]{0, 1},
                        new int[]{1, 1},
                        new int[]{2, 1},
                        new int[]{2, 0}
                }, new int[][]{
                        new int[]{0, 0},
                        new int[]{1, 0},
                        new int[]{1, 1},
                        new int[]{1, 2}
                }, new int[][]{
                        new int[]{0, 0},
                        new int[]{0, 1},
                        new int[]{1, 0},
                        new int[]{2, 0}
                }, new int[][]{
                        new int[]{0, 0},
                        new int[]{0, 1},
                        new int[]{0, 2},
                        new int[]{1, 2}
                }
        );

        pieces.put("J", ints);

        ints = List.of(new int[][]{
                        new int[]{0, 0},
                        new int[]{0, 1},
                        new int[]{1, 1},
                        new int[]{2, 1}
                },
                new int[][]{
                        new int[]{1, 0},
                        new int[]{1, 1},
                        new int[]{1, 2},
                        new int[]{0, 2}
                },
                new int[][]{
                        new int[]{0, 0},
                        new int[]{1, 0},
                        new int[]{2, 0},
                        new int[]{2, 1}
                },
                new int[][]{
                        new int[]{0, 0},
                        new int[]{0, 1},
                        new int[]{0, 2},
                        new int[]{1, 0}
                });

        pieces.put("L", ints);

        ints = Collections.singletonList(new int[][]{
                new int[]{0, 0},
                new int[]{0, 1},
                new int[]{1, 0},
                new int[]{1, 1}
        });

        pieces.put("O", ints);


        ints = List.of(new int[][]{
                        new int[]{0, 0},
                        new int[]{1, 0},
                        new int[]{1, 1},
                        new int[]{2, 1}
                },
                new int[][]{
                        new int[]{0, 1},
                        new int[]{0, 2},
                        new int[]{1, 0},
                        new int[]{1, 1}
                });

        pieces.put("S", ints);


        ints = List.of(new int[][]{
                new int[]{0, 1},
                new int[]{1, 0},
                new int[]{1, 1},
                new int[]{2, 1}
        }, new int[][]{
                new int[]{0, 0},
                new int[]{1, 0},
                new int[]{1, 1},
                new int[]{2, 0}
        }, new int[][]{
                new int[]{0, 1},
                new int[]{1, 0},
                new int[]{1, 1},
                new int[]{1, 2}
        }, new int[][]{
                new int[]{0, 0},
                new int[]{0, 1},
                new int[]{0, 2},
                new int[]{1, 1}
        });

        pieces.put("T", ints);

        ints = List.of(new int[][]{
                new int[]{0, -1},
                new int[]{1, 0},
                new int[]{1, -1},
                new int[]{2, 0}
        }, new int[][]{
                new int[]{0, 0},
                new int[]{0, -1},
                new int[]{1, -1},
                new int[]{1, -2}
        });

        pieces.put("Z", ints);

    }

    private static List<int[]> toBoard(String[] strArr, int columnNum, int rowNum) {

        List<int[]> list = new ArrayList<>();

        for (int i = 1; i < strArr.length; i++) {
            int[] ints = new int[rowNum];
            Arrays.fill(ints, 1);

            int colNum = Integer.parseInt(strArr[i]);
            for (int j = 0; j < rowNum - colNum; j++) {
                ints[j] = 0;
            }
            list.add(ints);
        }

        return list;
    }

    public static void main(String[] args) {
        String[] strings = {"I", "2", "4", "3", "4", "5", "2", "0", "2", "2", "3", "3", "3"};
        TetrisMove_M(strings);

        String[] strings1 = {"O", "4", "3", "2", "3", "5", "1", "0", "1", "2", "4", "3", "4"};
    }

}
