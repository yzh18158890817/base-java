package se.stream;

import java.util.Date;

/**
 * @author yzh
 * @date 2019/8/9
 */
public class DateTest {
    public static void main(String[] args) {
        Date date = new Date();
        String string = date.toString();

        System.out.println(string.substring(string.length()-4));
    }
}
