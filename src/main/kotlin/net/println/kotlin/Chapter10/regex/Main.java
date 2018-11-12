package net.println.kotlin.Chapter10.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String... arg) {
        String source = "Hello,This my phone number:010-12345667";
        String pattern = ".*(\\d{3}-\\d{8}).*";
        Matcher matcher = Pattern.compile(pattern).matcher(source);

        while (matcher.find()) {
            System.out.println(matcher.group());
            System.out.println(matcher.group(1));
        }
    }
}
