package Coderbyte.Hard;

public class ConnectFourWinner_M {

    public String ConnectFourWinner_M(String[] strArr) {
        char player = strArr[0].charAt(0);

        char[][] board = createBoard(strArr);


        // vertical check
        for (int i = 0; i < board.length - 3; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == 'x'
                        && player == board[i + 1][j]
                        && player == board[i + 2][j]
                        && player == board[i + 3][j]) {
                    return "(" + (i + 1) + "x" + (j + 1) + ")";
                }
            }
        }

        // horizontal check
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length - 3; j++) {
                if (board[i][j] == 'x'
                        && player == board[i][j + 1]
                        && player == board[i][j + 2]
                        && player == board[i][j + 3]) {
                    return "(" + (i + 1) + "x" + (j + 1) + ")";
                }
            }
        }

        // horizontal check 2
        for (int i = 0; i < board.length; i++) {
            for (int j = 3; j < board[0].length; j++) {
                if (board[i][j] == 'x'
                        && player == board[i][j - 1]
                        && player == board[i][j - 2]
                        && player == board[i][j - 3]) {
                    return "(" + (i + 1) + "x" + (j + 1) + ")";
                }
            }
        }

        // diagonal check
        for (int i = 0; i < board.length - 2; i++) {
            for (int j = 0; j < board[0].length - 3; j++) {
                if (board[i + 1][j] != 'x' && board[i][j] == 'x'
                        && player == board[i + 1][j + 1]
                        && player == board[i + 2][j + 2]
                        && player == board[i + 3][j + 3]) {
                    return "(" + (i + 1) + "x" + (j + 1) + ")";
                }
            }
        }

        // diagonal check 2
        for (int i = 0; i < board.length - 2; i++) {
            for (int j = board[0].length - 1; j >= 3; j--) {
                if (board[i + 1][j] != 'x' && board[i][j] == 'x'
                        && player == board[i + 1][j - 1]
                        && player == board[i + 2][j - 2]
                        && player == board[i + 3][j - 3]) {
                    return "(" + (i + 1) + "x" + (j + 1) + ")";
                }
            }
        }

        return "none";
    }

    private char[][] createBoard(String[] strArr) {
        char[][] board = new char[6][7];

        for (int i = 1; i < strArr.length; i++) {
            String[] split = strArr[i].substring(1, strArr[i].length() - 1).split(",");
            for (int j = 0; j < split.length; j++) {
                board[i - 1][j] = split[j].charAt(0);
            }
        }

        return board;
    }

    public static void main(String[] args) {
//        String[] strings = {"R", "(x,x,x,x,x,x,x)", "(x,x,x,x,x,x,x)", "(x,x,x,x,x,x,x)", "(x,x,x,R,x,x,x)", "(x,x,x,R,x,x,x)", "(x,x,x,R,Y,Y,Y)"};
//        ConnectFourWinner_M m = new ConnectFourWinner_M();
//        String s = m.ConnectFourWinner_M(strings);
//        System.out.println(s);
//
//        String[] strings1 = {"R", "(x,x,x,x,x,x,x)", "(x,x,x,x,x,x,x)", "(x,x,x,Y,x,x,x)", "(x,x,x,R,x,x,x)", "(x,x,x,R,x,x,x)", "(x,x,x,R,Y,Y,Y)"};
//        String s1 = m.ConnectFourWinner_M(strings1);
//        System.out.println(s1);
//
//        ConnectFourWinner_M m = new ConnectFourWinner_M();
//        String[] strings3 = {"Y", "(x,x,x,x,x,x,x)", "(x,x,x,x,x,x,x)", "(x,x,x,x,x,x,x)", "(x,x,x,x,x,x,x)", "(x,x,x,x,x,x,x)", "(Y,Y,Y,x,R,R,R)"};
//        String s3 = m.ConnectFourWinner_M(strings3);
//        System.out.println(s3);

//        String[] strings4 = {"R", "(x,x,x,x,x,x,x)", "(x,x,x,x,x,x,x)", "(x,x,x,x,x,x,x)", "(x,x,x,R,Y,x,Y)", "(x,x,x,R,R,Y,R)", "(x,x,x,Y,R,R,Y)"};
//        ConnectFourWinner_M m = new ConnectFourWinner_M();
//        String s4 = m.ConnectFourWinner_M(strings4);
//        System.out.println(s4);

//        String[] strings5 = {"Y", "(x,x,x,x,x,x,x)", "(x,x,x,x,x,x,x)", "(x,x,x,x,x,x,x)", "(x,x,x,R,Y,x,Y)", "(x,x,x,R,R,Y,R)", "(x,x,x,Y,R,R,Y)"};
//        ConnectFourWinner_M m = new ConnectFourWinner_M();
//        String s5 = m.ConnectFourWinner_M(strings5);
//        System.out.println(s5);

//        String[] strings6 = {"Y", "(x,x,x,x,x,x,x)", "(x,x,x,x,x,x,x)", "(x,x,x,x,x,x,x)", "(R,x,Y,R,x,x,x)", "(R,Y,R,R,x,x,x)", "(Y,R,R,Y,x,x,x)"};
//        ConnectFourWinner_M m1 = new ConnectFourWinner_M();
//        String s6 = m1.ConnectFourWinner_M(strings6);
//        System.out.println(s6);
    }

}