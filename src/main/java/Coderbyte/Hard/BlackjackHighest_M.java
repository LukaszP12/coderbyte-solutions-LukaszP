package Coderbyte.Hard;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class BlackjackHighest_M {

    public static String BlackjackHighest_M(String[] strArr) {
        HashMap<String, Integer> cardValues = new HashMap<>();
        cardValues.put("two", 2);
        cardValues.put("three", 3);
        cardValues.put("four", 4);
        cardValues.put("five", 5);
        cardValues.put("six", 6);
        cardValues.put("seven", 7);
        cardValues.put("eight", 8);
        cardValues.put("nine", 9);
        cardValues.put("ten", 10);
        cardValues.put("king", 10);
        cardValues.put("jack", 10);
        cardValues.put("queen", 10);

        List<String> deck = Arrays.stream(strArr).collect(Collectors.toList());

        int sumOfCards = 0;
        int acesCount = 0;
        String largestValue = "";
        int lValue = 0;

        for (int i = 0; i < strArr.length; i++) {
            if (cardValues.containsKey(strArr[i])) {
                sumOfCards += cardValues.get(strArr[i]);
                if (lValue < cardValues.get(strArr[i])) {
                    largestValue = strArr[i];
                    lValue = cardValues.get(strArr[i]);
                }
                if (cardValues.get(strArr[i]) == 10 && lValue == 10) {
                    if (largestValue == "ten" && strArr[i] != "ten") {
                        largestValue = strArr[i];
                    }
                }
            } else {
                acesCount++;
            }
        }

        for (int i = 0; i < acesCount; i++) {
            if (sumOfCards + 11 > 21) {
                sumOfCards = sumOfCards + 1;
            } else {
                sumOfCards = sumOfCards + 11;
                largestValue = "ace";
            }
        }


        String result = "";

        if (sumOfCards == 21) {
            result += "blackjack";
        } else if (sumOfCards < 21) {
            result += "below";
        } else if (sumOfCards > 21) {
            result += "above";
        }

        result += " " + largestValue;


        return result;
    }

    public static void main(String[] args) {
//        String[] strings = {"four", "ace", "ten"};
//        System.out.println(BlackjackHighest_M(strings));

//        String[] strings1 = {"ace", "queen"};
//        System.out.println(BlackjackHighest_M(strings1));

//        String[] strings2 = {"king", "ace", "two"};
//        System.out.println(BlackjackHighest_M(strings2));

//        String[] strings3 = {"queen", "ace", "ten"};
//        System.out.println(BlackjackHighest_M(strings3));

//        String[] strings4 = {"queen", "ace", "seven"};
//        System.out.println(BlackjackHighest_M(strings4));

//        String[] strings5 = {"five", "ten", "king"};
//        System.out.println(BlackjackHighest_M(strings5));
    }

}
