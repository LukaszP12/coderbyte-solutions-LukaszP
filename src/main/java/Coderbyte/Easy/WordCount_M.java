package Coderbyte.Easy;


public class WordCount_M {

    public static int WordCount(String str) {
        String[] split = str.split("\\s");

        return split.length;
    }

    public static void main(String[] args) {
        String s = "Hello World";
        System.out.println(WordCount(s));

        String s1 = "one 22 three";
        System.out.println(WordCount(s1));
    }

}
