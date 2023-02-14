package Coderbyte.Easy;

import java.util.Arrays;
import java.util.Comparator;


public class ThirdGreatest_M {

    public static String ThirdGreatest_M(String[] strArr) {

        String[] copy = Arrays.copyOfRange(strArr, 0, strArr.length);

        Arrays.sort(copy, Comparator.comparingInt(String::length));

        int thirdLongestLength = copy[copy.length - 3].length();

        for (int i = strArr.length - 1; i > -1; i--) {
            if (strArr[i].length() == thirdLongestLength) {
                return strArr[i];
            }
        }

        return "";
    }


    public static void main(String[] args) {
        String[] strings = {"coder", "byte", "code"};
        System.out.println(ThirdGreatest_M(strings));

        String[] strings1 = {"abc", "defg", "z", "hijk"};
        System.out.println(ThirdGreatest_M(strings1));

        String[] strings2 = {"abcd", "abc", "ab", "a"};
        System.out.println(ThirdGreatest_M(strings2));

        String[] strings3 = {"two", "three", "four"};
        System.out.println(ThirdGreatest_M(strings3));

        String[] strings4 = {"hello", "world", "world"};
        System.out.println(ThirdGreatest_M(strings4));

        String[] strings5 = {"bat", "cat", "mat"};
        System.out.println(ThirdGreatest_M(strings5));

        String[] strings6 = {"bt", "ct", "mtyyyy"};
        System.out.println(ThirdGreatest_M(strings6));

        String[] strings7 = {"hello", "world", "after", "all"};
        System.out.println(ThirdGreatest_M(strings7));

    }

}