package Coderbyte.Easy;

public class VowelSquare_M {

    static final String vowels = "aeijouy";

    public static String VowelSquare_M(String[] strArr) {

        for (int i = 1; i < strArr.length; i++) {
            for (int j = 1; j < strArr[0].length(); j++) {
                if (vowels.contains("" + strArr[i - 1].charAt(j - 1))) {
                    if (vowels.contains("" + strArr[i - 1].charAt(j))) {
                        if (vowels.contains("" + strArr[i].charAt(j - 1))) {
                            if (vowels.contains("" + strArr[i].charAt(j))) {
                                return (i - 1) + "-" + (j - 1);
                            }
                        }
                    }

                }
            }
        }

        return "not found";
    }

    public static void main(String[] args) {
        String[] strings = {"aqrst", "ukaei", "ffooo"};
        System.out.println(VowelSquare_M(strings));

        String[] strings1 = {"gg", "ff"};
        System.out.println(VowelSquare_M(strings1));
    }

}
