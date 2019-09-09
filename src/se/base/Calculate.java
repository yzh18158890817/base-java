package se.base;

import java.text.DecimalFormat;
import java.util.Scanner;

import static javax.xml.bind.DatatypeConverter.parseString;

/**
 * @author yzh
 * @date 2019/8/30
 *  * * 山鬼谣
 * 3`4`？6^.   7，6^.    3`，3^、7^.   4^？5，4，5`.
 * 3`，6^，6^.   7，6^.    3`，3^，7^.   4^，5，4，5`.
 * 孰明了,浮生一梦()?满腹忧思谁许(何去).
 * 明月最能催人念,卷帘和光聆取(凝语)().
 * 怅然绪,离人语(),就中更有无妄侶.
 * 它因解羽?明灭皆随缘,剑出半鞘,锋芒照天惧.
 * 魂归()路(处),寂寞当年孤苦,一将终成枯骨(古).
 * 不解犹有襄王梦,更殇几回离嘱().
 * 星怅顾,月也嘱,江山莫看英魂骨.
 * 一抔殇土,一剑荡八荒,酒醉半醒,郁郁魂忘故(顾).
 */
public class Calculate {
    public static void main(String[] args) {
        System.out.println("开机完毕！(输入set进行系统设置（默认保留两位小数）)");
        Scanner scanner = new Scanner(System.in);
        DecimalFormat df = new DecimalFormat("0.00");
        while (true) {
            Long result = null;
            String symbol = null;
            String num1 = null;
            String num2 = null;
            getCalculate(scanner, symbol, num1, num2, df);
            System.out.println("是否继续（y/n）");
            String next = scanner.next();
            if (next.equalsIgnoreCase("y")) {
                getCalculate(scanner, symbol, num1, num2, df);
            }
            if (next.equalsIgnoreCase("n")) {
                System.exit(0);
            }
        }
    }

    private static void getCalculate(Scanner scanner, String symbol, String num1, String num2, DecimalFormat df) {
        Long result;
        System.out.print("请输入算式：");
        String str = scanner.next();
        if (str.equalsIgnoreCase("set")) {
            df = setCount(scanner);
            getCalculate(scanner, symbol, num1, num2, df);
            return;
        }
        if (!Character.isDigit(str.charAt(0)) || !Character.isDigit(str.charAt(str.length() - 1))) {
            System.out.println("算式非法，请重新输入");
            getCalculate(scanner, symbol, num1, num2, df);
        }
        if (!(str.contains("+") || str.contains("-") || str.contains("*") || str.contains("/"))) {
            System.out.println("算式非法，请重新输入");
            getCalculate(scanner, symbol, num1, num2, df);
        }

        result = judgeFormula(str, scanner, num1, num2, df, symbol);

//        System.out.println(getSymbol(str,scanner,symbol,num1,num2,df)); 
        System.out.println(result);
    }

    private static Long judgeFormula(String str, Scanner scanner, String num1, String num2, DecimalFormat df, String symbol) {
        Long result = 0L;
        String lastSymbol = "+";
        if (!str.contains("(")) {
            if (!isNum(str) && !isNum(str.substring(0, 1))) {
                lastSymbol = str.substring(0, 1);
                str = str.substring(1, str.length());
            }
            for (int i = 0; i < str.length(); i++) {
                if (!Character.isDigit(str.charAt(i))) {
                    symbol = str.charAt(i) + "";
                    num1 = lastSymbol + str.substring(0, i);
                    num2 = str.substring(i, str.length());
                    //判断符号
                    return getSymbol(str, scanner, symbol, num1, num2, df, result);
                }
            }
        } else {
            return null;
        }
        return null;
    }

    public static boolean isNum(String str) {
        for (int i = 0; i < str.length(); i++) {
            if (!Character.isDigit(str.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    private static Long getSymbol(String str, Scanner scanner, String symbol, String num1, String num2, DecimalFormat df, Long result) {
        switch (symbol) {
            case "+":
                return getAdd(scanner, symbol, num1, num2, df, result);
            case "-":
                return getAdd(scanner, symbol, num1, num2, df, result);
            case "*":
                String parseString = getParseString(str);
                judgeFormula(str, scanner, num1, num2, df, symbol);
                String lastSymbol = num1.substring(0, 1);
                String thisSymbol = num2.substring(0, 1);
                return result*Long.parseLong(num1)+Long.parseLong(parseString);
            case "/":
                if (isNum(num2)) {
                    result = Long.parseLong(num1) / Long.parseLong(num2);
                } else {
                    str = num2;
                    result = Long.parseLong(num1) / judgeFormula(str, scanner, num1, num2, df, symbol);
                }
                return result;
//                System.out.println("算式结果为：" + df.format((double) num1 / num2));
            default:
                getCalculate(scanner, symbol, num1, num2, df);
                return null;
        }
    }

    private static String getParseString(String str) {
        String lastSymbol = str.substring(0, 1);
        if (isNum(lastSymbol)) {
            return lastSymbol;
        }
        str = str.substring(1, str.length());
        if (!isNum(str)) {
            for (int i = 0; i < str.length(); i++) {
                if (Character.isDigit(str.charAt(i))) {
                    return lastSymbol+str.substring(0, i);
                }
            }
        }
        return str;
    }

    private static Long getAdd(Scanner scanner, String symbol, String num1, String num2, DecimalFormat df, Long result) {
        String str;
        if (!isNum(num2.substring(1, num2.length()))) {
            str = num2;
            result = result + Long.parseLong(num1) + judgeFormula(str, scanner, num1, num2, df, symbol);
        } else {
            result = result + Long.parseLong(num1) + Long.parseLong(num2);
        }
        return result;
    }

    private static DecimalFormat setCount(Scanner scanner) {
        DecimalFormat df;
        System.out.print("请设置保留小数位数：");
        int count = scanner.nextInt();
        if (count > 0) {
            String strCount = "0.";
            for (int i = 0; i < count; i++) {
                strCount = strCount + "0";
            }
            df = new DecimalFormat(strCount);
        } else {
            df = new DecimalFormat("0");
        }
        return df;
    }
}
