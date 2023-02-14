package Coderbyte.Hard;

import java.util.*;
import java.util.stream.Collectors;

public class CountingAnagrams_M {

    public static int CountingAnagrams(String str) {
        String[] split = str.split("\\s");
        List<List<String>> knowAnagrams = new ArrayList<List<String>>();

        int result = 0;

        String[] split2 = removeIdentical(split);

        for (int i = 0; i < split2.length; i++) {
            String s = split2[i];
            boolean isAnagram = false;

            for (int j = i + 1; j < split2.length; j++) {
                String s1 = split2[j];

                if (!knowAnagrams.contains(stringToList(s).stream().sorted().collect(Collectors.toList())) && isAnagram(s, s1)) {
                    result++;
                    isAnagram = true;
                }
            }

            if (isAnagram) {
                knowAnagrams.add(stringToList(s).stream().sorted().collect(Collectors.toList()));
            }

        }

        return result;
    }

    private static List<String> stringToList(String s) {
        String[] split = s.split("");

        List<String> strings = Arrays.asList(split);

        return strings;
    }

    private static boolean isAnagram(String s, String s1) {
        if (s.equals(s1)) {
            return false;
        }

        char[] charArray = s.toCharArray();
        char[] charArray1 = s1.toCharArray();

        Arrays.sort(charArray);
        Arrays.sort(charArray1);

        String sorted1 = "";
        String sorted2 = "";

        for (char c : charArray) {
            sorted1 += "" + c;
        }

        for (char c : charArray1) {
            sorted2 += "" + c;
        }

        return charArray.length == charArray1.length && (sorted1.equals(sorted2));
    }

    private static String[] removeIdentical(String[] split) {
        Set<String> set = new HashSet<>();

        for (String s : split) {
            set.add(s);
        }

        String[] newArray = new String[set.size()];

        String[] strings = set.toArray(newArray);

        return strings;
    }


    public static void main(String[] args) {
        String s = "aa aa odg dog gdo";
        System.out.println(CountingAnagrams(s));

        String s1 = "a c b c run urn urn";
        System.out.println(CountingAnagrams(s1));

        String s2 = "cars are very cool so are arcs and my os";
        System.out.println(CountingAnagrams(s2));
    }

}
