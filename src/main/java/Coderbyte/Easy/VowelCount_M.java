package Coderbyte.Easy;

import java.util.Arrays;
import java.util.List;

public class VowelCount_M {

    public static int VowelCount(String str) {
//        char[] charArray = {'a', 'e', 'i', 'j', 'o', 'u'};

        List<Character> vowels = Arrays.asList('a', 'e', 'i', 'j', 'o', 'u');

        char[] charArray1 = str.toCharArray();
        int counter = 0;

        for (char c : charArray1) {
            if (vowels.contains(c)) {
                counter++;
            }
        }

        return counter;
    }

    public static void main(String[] args) {
        String hello = "hello";
        System.out.println(VowelCount(hello));

        String coderbyte = "coderbyte";
        System.out.println(VowelCount(coderbyte));
    }

}
