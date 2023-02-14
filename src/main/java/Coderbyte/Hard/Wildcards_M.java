package Coderbyte.Hard;

public class Wildcards_M {

    public static boolean Wildcards_M(String str) {
        String[] split = str.split("\\s");

        int pointer = 0;
        int i = 0;


        for (; i < split[0].length(); i++) {

            if (pointer > split[1].length() - 1) {
                break;
            }

            if (split[0].charAt(i) == '$' && Character.isDigit(split[1].charAt(pointer))) {
                pointer++;
                continue;
            }

            if (split[0].charAt(i) == '+' && !Character.isAlphabetic(split[1].charAt(pointer))) {
                return false;
            }

            if (split[0].charAt(i) == '+' && Character.isAlphabetic(split[1].charAt(pointer))) {
                pointer++;
                continue;
            } else if ((i < split[0].length() - 1) && split[0].charAt(i) == '*' && split[0].charAt(i + 1) != '{') {
                if (Character.isAlphabetic(split[1].charAt(pointer)) && split[1].charAt(pointer) == split[1].charAt(pointer + 1) && split[1].charAt(pointer + 1) == split[1].charAt(pointer + 2)) {
                    pointer = pointer + 3;
                    continue;
                }
            } else if ((i < split[0].length() - 1) && split[0].charAt(i) == '*' && split[0].charAt(i + 1) == '{') {
                int num = Integer.parseInt("" + split[0].charAt(i + 2));
                if (Character.isAlphabetic(split[1].charAt(pointer))) {
                    char nextChar = split[1].charAt(pointer);

                    while (pointer < pointer + num) {
                        char charAt = split[1].charAt(pointer);
                        if (charAt != nextChar) {
                            return false;
                        }
                        pointer++;
                    }

                }

                continue;
            }

        }


        return true;
    }

    public static void main(String[] args) {
//        String s = "+++++* abcdemmmmmm";
//        System.out.println(Wildcards_M(s));

        String s1 = "**+*{2} mmmrrrkbb";
        System.out.println(Wildcards_M(s1));
    }

}