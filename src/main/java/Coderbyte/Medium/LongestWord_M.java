package Coderbyte.Medium;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.regex.Pattern;

public class LongestWord_M {

    public static String LongestWord_M(String sen) {
        sen = sen.replaceAll("[^a-zA-Z0-9\\s]", "");
        String[] split = sen.split(" ");

        String[] strings = Arrays.stream(split).sorted(Comparator.comparingInt(String::length)).toArray(String[]::new);

        return strings[strings.length - 1];
    }

    public static void main(String[] args) {
        System.out.println(LongestWord_M("fun&!! time"));
        System.out.println(LongestWord_M("I love dogs"));
        System.out.println(LongestWord_M("this is some sort of sentence"));

        // wrong cannot capture original ordering
        System.out.println(LongestWord_M("hello world"));
    }

}
