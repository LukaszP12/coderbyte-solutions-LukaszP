package Coderbyte.Easy;

public class RemoveBrackets_M {

    public static int RemoveBrackets(String str) {
        int totalLength = str.length();

        str = str.replaceAll("\\)", "");
        int removed = totalLength - str.length();

        int leftBracket = str.length();

        return Math.abs(leftBracket - removed);
    }

    public static void main(String[] args) {
        System.out.println(RemoveBrackets("(())()((("));
        System.out.println(RemoveBrackets("(()("));


        // incorrect case
        System.out.println(RemoveBrackets(")(()"));
        //toDo
        // the solution is wrong, as direction is not captured
    }

}
