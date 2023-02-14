package Coderbyte.Easy;

public class QuestionsMarks_M {

    public static boolean QuestionsMarks(String str) {

        int prev_number = 0;
        boolean prev_num = false;

        boolean isCorrect = false;

        int counter = 0;


        for (int i = 0; i < str.length(); i++) {

            if (!prev_num && Character.isDigit(str.charAt(i))) {
                prev_number = Integer.parseInt("" + str.charAt(i));
                prev_num = true;
                continue;
            }

            if (prev_num && Character.isDigit(str.charAt(i))) {
                if (prev_number + Integer.parseInt("" + str.charAt(i)) == 10) {
                    if (counter == 3) {
                        isCorrect = true;
                    } else if (counter != 3) {
                        return false;
                    }
                }

                prev_number = Integer.parseInt("" + str.charAt(i));
                prev_num = true;
                counter = 0;
            }

            if (prev_num && str.charAt(i) == '?') {
                counter++;
                System.out.println(counter);
            }

        }


        return isCorrect ? true : false;
    }


    public static void main(String[] args) {
//        System.out.println(QuestionsMarks("aa6?9"));
//        System.out.println(QuestionsMarks("acc?7??sss?3rr1??????5"));
//        System.out.println(QuestionsMarks("9???1???9??1???9"));


//         incorrect case
        String s = "5??aaaaaaaaaaaaaaaaaaa?5?a??5";
        System.out.println(QuestionsMarks("5??aaaaaaaaaaaaaaaaaaa?5?a??5"));

    }

}
