package ua.epam.task7.ip;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegularExpression {
    public static void main(String[] args) {
        String example = "178.25.35.0 09.178.04.5";
        String example2 = "2001:db8:3333:4444:5555:6666:7777:8888 2001:db8:3333:4444:5555:6666:7777:8888 ::  ::1234:5678 2001:db8::";
        Ipv4(example);
        Ipv6(example2);
    }

    private static void Ipv4(String example) {
        String regex = "((25[0-5]|2[0-4][0-9]|[0-1]?[0-9]?[0-9])\\.){3}(25[0-5]|2[0-4][0-9]|[0-1]?[0-9]?[0-9])";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(example);

        while(matcher.find()) {
            System.out.println(matcher.group());
        }
    }

    private static void Ipv6(String example) {
        String regex = "((([A-Fa-f0-9]){0,4}:){2,7})(([A-Fa-f0-9]){0,4})";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(example);

        while(matcher.find()) {
            System.out.println(matcher.group());
        }
    }
}
