package se.base;

import java.text.DecimalFormat;
import java.util.Scanner;
import java.util.stream.Stream;

/**
 * @author yzh
 * @date 2019/8/30
 */
public class Calculate {
    public static void main(String[] args) {
        System.out.println("开机完毕！(输入set进行系统设置（默认保留两位小数）)");
        Scanner scanner = new Scanner(System.in);
        DecimalFormat df = new DecimalFormat("0.00");
        while (true) {
            Long result = null;
            String symbol = null;
            Long num1 = null;
            Long num2 = null;
            getCalculate(scanner, symbol, num1, num2,df);
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

    private static void getCalculate(Scanner scanner, String symbol, Long num1, Long num2, DecimalFormat df) {
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
        for (int i = 0; i < str.length(); i++) {
            if (!Character.isDigit(str.charAt(i))) {
                symbol = str.charAt(i) + "";
                String str1 = str.substring(0, i);
                for (char c1 : str1.toCharArray()) {
                    if (!Character.isDigit(c1)) {
                        System.out.println("算式非法，请重新输入");
                        getCalculate(scanner, symbol, num1, num2, df);
                    }
                }
                num1 = Long.parseLong(str1);
                String str2 = str.substring(i + 1, str.length());
                for (char c2 : str2.toCharArray()) {
                    if (!Character.isDigit(c2)) {
                        System.out.println("算式非法，请重新输入");
                        getCalculate(scanner, symbol, num1, num2, df);
                    }
                }
                num2 = Long.parseLong(str2);
            }
        }
        switch (symbol) {
            case "+":
                result = num1 + num2;
                System.out.println("算式结果为："+result);
                break;
            case "-":
                result = num1 - num2;
                System.out.println("算式结果为："+result);
                break;
            case "*":
                result = num1 * num2;
                System.out.println("算式结果为："+result);
                break;
            case "/":
                System.out.println("算式结果为："+df.format((double)num1 / num2));
                break;
            default:
                System.out.println("算式非法，请重新输入");
                getCalculate(scanner, symbol, num1, num2, df);
        }
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
            df= new DecimalFormat(strCount);
        } else {
            df = new DecimalFormat("0");
        }
        return df;
    }
}
