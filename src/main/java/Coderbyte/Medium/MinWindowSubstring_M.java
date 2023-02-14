package Coderbyte.Medium;

public class MinWindowSubstring_M {

    public static String MinWindowSubstring_M(String[] strArr) {
        String main_string = strArr[0];
        String k_chars = strArr[1];

        int max_length = Integer.MAX_VALUE;
        String shortest_string = "";

        for (int i = 0; i < main_string.length(); i++) {
            for (int j = i + 1; j <= main_string.length(); j++) {
                String sub = main_string.substring(i, j);

                if (canBuild(sub, k_chars)) {
                    int length = sub.length();
                    if (length < max_length) {
                        max_length = length;
                        shortest_string = sub;
                    }
                }

            }
        }

        return shortest_string;
    }

    private static boolean canBuild(String sub, String k_chars) {

        int i = 0;

        while (true) {

            char charAt = sub.charAt(i);

            if (k_chars.contains("" + charAt)) {
                int i1 = k_chars.indexOf(charAt);
                String new_sub = k_chars.substring(0, i1) + k_chars.substring(i1 + 1);
                k_chars = new_sub;
            }

            if (k_chars.isEmpty()) {
                break;
            }

            i++;

            if (i == sub.length() && k_chars.length() > 0) {
                return false;
            }
        }

        return true;
    }


    public static void main(String[] args) {
        String[] strings = {"ahffaksfajeeubsne", "jefaa"};
        System.out.println(MinWindowSubstring_M(strings));

        String[] strings1 = {"aaffhkksemckelloe", "fhea"};
        System.out.println(MinWindowSubstring_M(strings1));
    }


}