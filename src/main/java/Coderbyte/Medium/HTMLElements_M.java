package Coderbyte.Medium;

import java.util.*;

public class HTMLElements_M {

    public static String HTMLElements_M(String str) {
        Stack<String> stack = new Stack<>();
        Stack<String> stack1 = new Stack<>();

        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '<' && str.charAt(i + 1) != '/') {
                i++;
                StringBuilder builder = new StringBuilder();
                while (str.charAt(i) != '>') {
                    builder.append(str.charAt(i));
                    i++;
                }
                String word = builder.toString();
                stack.add(word);
            } else if (str.charAt(i) == '<' && str.charAt(i + 1) == '/') {
                i++;
                i++;
                StringBuilder builder1 = new StringBuilder();
                while (str.charAt(i) != '>') {
                    builder1.append(str.charAt(i));
                    i++;
                }
                String word1 = builder1.toString();
                stack1.add(word1);

                if (!stack.isEmpty()) {
                    if (stack.peek().equals(stack1.peek())) {
                        stack.pop();
                        stack1.pop();
                    } else if (!stack.peek().equals(stack1.peek())) {
                        return stack.pop();
                    }
                }

            }

        }

        if (stack.isEmpty() && stack1.isEmpty()) {
            return "true";
        } else if (stack1.isEmpty() && !stack.isEmpty()) {
            return stack.pop();
        } else if (stack.isEmpty() && !stack1.isEmpty()) {
            return stack1.pop();
        }

        return "true";
    }

    public static void main(String[] args) {
        String html1 = "<div><div><b></b></div></p>";
        System.out.println(HTMLElements_M(html1));

        String html2 = "<div>abc</div><p><em><i>test test test</b></em></p>";
        System.out.println(HTMLElements_M(html2));

        String s = "<div><b><p>hello world</p></b></div>";
        System.out.println(HTMLElements_M(s));

        String s1 = "<p>hello</p><div></div>";
        System.out.println(HTMLElements_M(s1));

        String s2 = "hello world<p></p><div><em><b></b></em></p>";
        System.out.println(HTMLElements_M(s2));

        String s3 = "<div>";
        System.out.println(HTMLElements_M(s3));
    }

}
