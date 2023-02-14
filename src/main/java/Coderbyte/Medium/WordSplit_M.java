package Coderbyte.Medium;

import java.util.ArrayList;


public class WordSplit_M {

    private static String word;

    public static String WordSplit_M(String[] strArr) {
        String word = strArr[0];

        String[] dict = strArr[1].split(",");

        ArrayList<String> words = new ArrayList<>();

        for (String d : dict) {
            words.add(d);
        }


        String result = "";

        for (String s : words) {
            if (word.contains(s)) {
                result += s + ",";
            }
        }

        return result;
    }

    public static void main(String[] args) {
        String[] strings = {"baseball", "a,all,b,ball,bas,base,cat,code,d,e,quit,z"};
        System.out.println(WordSplit_M(strings));

//        String[] strings1 = {"abcgefd", "a,ab,abc,abcg,b,c,dog,e,efd,zzzz"};
//        System.out.println(WordSplit_M(strings1));
    }
}
