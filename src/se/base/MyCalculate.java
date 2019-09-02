package se.base;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author yzh
 * @date 2019/9/2
 */
public class MyCalculate {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            getRun(scanner);
            System.out.println("是否继续?(y/n)");
            String next = scanner.next();
            if (next.equalsIgnoreCase("y")) {
                getRun(scanner);
            }
            if (next.equalsIgnoreCase("n")) {
                System.exit(0);
            }
        }
    }

    private static void getRun(Scanner scanner) {
        try {
            System.out.println("请输入综合算式:");
            String str = scanner.nextLine();
            List<String> list = new ArrayList<>();
            getList(str, list);
            String result = getNum(list);
            System.out.println(result);
        } catch (Exception e) {
            System.out.println("格式不正确!");
            getRun(scanner);
        }
    }

    private static String getNum(List<String> list) {
        if (list.size() == 1) {
            return "="+list.get(0);
        }
        if (list.size() == 0) {
            return "格式不正确!";
        }
        getMultiply(list);
        getAdd(list);
        return "="+list.get(0);
    }

    private static List<String> getMultiply(List<String> list) {
        Double num1;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).equals("*") || list.get(i).equals("/")) {
                if (list.get(i).equals("*")) {
                    num1 = Double.parseDouble(list.get(i - 1)) * Double.parseDouble(list.get(i + 1));
                } else {
                    num1 = Double.parseDouble(list.get(i - 1)) / Double.parseDouble(list.get(i + 1));
                }
                for (int j = 0; j < 3; j++) {
                    list.remove(i - 1);
                }
                list.add(i - 1, num1.toString());
                getNum(list);
                return list;
            }
        }
        return list;
    }

    private static void getParentheses(List<String> list) {
        Double num1;
        Integer fromIndex = null;
        Integer toIndex = null;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).equals("(") || list.get(i).equals(")")) {
                if (list.get(i).equals("(")) {
                    fromIndex = i;
//                    num1 = Double.parseDouble(list.get(i - 1)) * Double.parseDouble(list.get(i + 1));
                } else {
//                    num1 = Double.parseDouble(list.get(i - 1)) / Double.parseDouble(list.get(i + 1));
                    toIndex = i;
                }
                List<String> subList = list.subList(fromIndex, toIndex);
                String result = getNum(subList);
                for (int j = fromIndex; j <= toIndex; j++) {
                    list.remove(fromIndex);
                }
                list.add(fromIndex, result);
                getNum(list);
                break;
            }
        }
    }

    private static List<String> getAdd(List<String> list) {
        Double num1;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).equals("+") || list.get(i).equals("-")) {
                if (list.get(i).equals("+")) {
                    num1 = Double.parseDouble(list.get(i - 1)) + Double.parseDouble(list.get(i + 1));
                } else {
                    num1 = Double.parseDouble(list.get(i - 1)) - Double.parseDouble(list.get(i + 1));
                }
                for (int j = 0; j < 3; j++) {
                    list.remove(i - 1);
                }
                list.add(i - 1, num1.toString());
                getNum(list);
                return list;
            }
        }
        return list;
    }

    private static void getList(String str, List<String> list) {
        for (int i = 0; i < str.length(); i++) {
            if (!Character.isDigit(str.charAt(i))) {
                list.add(str.substring(0, i));
                list.add(str.substring(i, i + 1));
                str = str.substring(i + 1, str.length());
                getList(str, list);
                break;
            }
            if (isNum(str)) {
                list.add(str);
            }
        }
    }

    private static boolean isNum(String str) {
        for (int i = 0; i < str.length(); i++) {
            if (!Character.isDigit(str.charAt(i))) {
                return false;
            }
        }
        return true;
    }
}
