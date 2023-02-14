package Coderbyte.Medium;

import java.util.Arrays;
import java.util.List;

public class CharacterRemoval_M {


    public static int CharacterRemoval_M(String[] strArr) {

        String word = strArr[0];

        int min_removal = word.length();

        String listOfWords = strArr[1];

        List<String> stringList = Arrays.asList(listOfWords.split(","));

        for (String s : stringList) {

            if (word.contains(s) || word.contains("" + s.charAt(0))) {
                String s1 = removeWord(word, s);

                String s2 = removeFromWord(word, s1);

                if (s.equals(s2)) {
                    int minToRemove = s1.length();
                    if (minToRemove < min_removal) {
                        min_removal = minToRemove;
                    }
                }


            }
        }

        return min_removal == word.length() ? -1 : min_removal;
    }

    private static String removeFromWord(String word, String s1) {

        if (word.contains(s1)) {
            return word.replaceFirst(s1, "");
        }

        int i = 0, j = 0;

        String result = "";

        while ((i < word.length()) && (j < s1.length())) {
            if (word.charAt(i) == s1.charAt(j)) {
                i++;
                j++;
            } else if (word.charAt(i) != s1.charAt(j)) {
                result += "" + word.charAt(i);
                i++;
            }
        }

        if (i < word.length()) {
            result += word.substring(i);
        }

        return result;
    }

    private static String removeWord(String word, String s) {
        String initWord = word;

        if (word.contains(s)) {
            return word.replaceFirst(s, "");
        }

        char[] charArray = s.toCharArray();

        for (char c : charArray) {
            if (word.contains("" + c)) {
                word = word.replaceFirst("" + c, "");
            }
        }

        if (word.length() == initWord.length() - s.length()) {
            return word;
        }

        return initWord;
    }

    public static void main(String[] args) {
        String[] strings = {"baseball", "a,all,b,ball,bas,base,cat,code,d,e,quit,z"};
        System.out.println(CharacterRemoval_M(strings));

        String[] strings1 = {"apbpleeeef", "a,ab,abc,abcg,b,c,dog,e,efd,zzzz"};
        System.out.println(CharacterRemoval_M(strings1));

        String[] strings2 = {"worlcde", "apple,bat,cat,goodbye,hello,yellow,why,world"};
        System.out.println(CharacterRemoval_M(strings2));

        String[] strings3 = {"apbpleeeef", "a,abc,abcg,b,c,dog,e,efd,zzzz"};
        System.out.println(CharacterRemoval_M(strings3));

        String[] strings4 = {"wrdlmaeo", "a,b,c,d,ap,apple,bar,bat,cat,hello,y,yellow,w,wo,world,worr"};
        System.out.println(CharacterRemoval_M(strings4));

        String[] strings5 = {"abbb", "c,d,e,f,g,h,i,j,k,yyyy,zzzzzzzz"};
        System.out.println(CharacterRemoval_M(strings5));

        String[] strings6 = {"abcdefabcdef", "a,b,c,d,e,ee,eee,eeee,eeeeeeeee,fabc,go,goo,gooo"};
        System.out.println(CharacterRemoval_M(strings6));

        // wrong
        String[] strings7 = {"abcdefabcdef", "a,b,bfabcde,c,d,e,ee,eee,eeee,eeeeeeeee,fabc,go,goo,gooo"};
        System.out.println(CharacterRemoval_M(strings7));
        // the correct output is 5

//        String s = removeWord("abcdefabcdef", "bfabcde");
//        System.out.println(s);
//
//        String s1 = removeFromWord("abcdefabcdef", "acdef");
//        System.out.println(s1);

    }

}
