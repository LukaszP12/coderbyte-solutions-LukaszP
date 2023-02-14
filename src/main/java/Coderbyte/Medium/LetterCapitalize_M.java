package Coderbyte.Medium;

public class LetterCapitalize_M {

    public static String LetterCapitalize_M(String str) {
        String[] split = str.split(" ");
        String result = "";

        for (int i = 0; i < split.length; i++) {
            String capLetter = String.valueOf(split[i].charAt(0)).toUpperCase();
            String newWord = capLetter + split[i].substring(1);
            result += newWord + " ";
        }

        return result;
    }

    public static String LetterCapitalize_2(String str) {
        StringBuffer sb = new StringBuffer();
        String[] words = str.split("\\s");
        for (int i = 0; i < words.length; i++) {
            sb.append(Character.toUpperCase(words[i].charAt(0)));
            sb.append(words[i].substring(1));
            sb.append(" ");
        }

        return sb.toString().trim();
    }

    public static void main(String[] args) {
        String hello = "hello world";
        System.out.println(LetterCapitalize_M(hello));
        System.out.println(LetterCapitalize_2(hello));

        String s = "i ran there";
        System.out.println(LetterCapitalize_M(s));
    }
}
