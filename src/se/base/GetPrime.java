package se.base;

import java.util.ArrayList;
import java.util.Scanner;

public class GetPrime {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("\033[36;1m该方法用于查找(0~所输入自然数)范围内所有质数...");
        Scanner scanner = new Scanner(System.in);
        getPrime(scanner);
        while (true) {
            System.out.println("\033[36;1m是否继续?(按Y回车继续,按任意键回车退出)\033[0m");
            String next = scanner.next();
            if ("y".equalsIgnoreCase(next)) {
                getPrime(scanner);
            } else {
                System.exit(0);
            }
        }
    }

    private static void getPrime(Scanner scanner) throws InterruptedException {
        System.out.print("\033[36;1m请输入任意自然数:" + "\033[0m");
        String next;
        int num;
        int countNum = 0;
        while (true) {
            next = scanner.next();
            if (isNum(next)) {
                num = Integer.parseInt(next);
                if (num == 0 || num == 1) {
                    System.out.println("\033[31;1m您输入的范围内没有质数，请重新输入：\033[0m");
                } else if (num == 2) {
                    System.out.println("\033[31;1m您输入的数字为2,2为最小质数\033[0m");
                    break;
                } else {
                    break;
                }
            } else {
                System.out.println("\033[31;1m输入类型错误,请输入自然数:");
                countNum++;
                if (countNum == 3) {
                    System.out.println("\033[31;1m你特么不识字啊,再和我抬扛我炸死你信不信,有种再输错两次试试");
                }
                if (countNum == 5) {
                    System.out.println("\033[31;1m你已五次输入错误,计算机将于三秒后爆炸\033[0m");
                    System.out.println("\033[31;1m倒计时开始...\033[0m");
                    Thread.sleep(1000);
                    System.out.println("\033[31;1m3...\033[0m");
                    Thread.sleep(1000);
                    System.out.println("\033[31;1m2...\033[0m");
                    Thread.sleep(1000);
                    System.out.println("\033[31;1m1...\033[0m");
                    System.out.println("\033[31;1m沙雕,不陪你玩,爷爷退出了\033[0m");
                    System.exit(0);
                }

            }
        }
        if (num > 2) {
            ArrayList<Integer> list = new ArrayList<>();
            System.out.println("\033[31;1m(0~" + num + ")\033[0m" + "\033[35;1m之内的所有质数为:" + "\033[0m");
            for (int i = 2; i <= num; i++) {
                boolean flag = true;
                for (int j = 2; j < i; j++) {
                    if (i % j == 0) {
                        flag = false;
                        break;
                    }
                }
                if (flag) {
                    list.add(i);
                }
            }
            int count = 0;
            for (Integer integer : list) {
                count++;
                if (count != list.size()) {
                    System.out.print("\033[32;5m" + integer + "\033[0m" + ",");
                }
                if (count == list.size()) {
                    System.out.println("\033[32;5m" + integer + "\033[0m");
                }
                if (count % 20 == 0) {
                    System.out.println();
                }
            }
            System.out.println("\033[35;1m总计\033[0m\033[31;1m" + list.size() + "\033[0m\033[35;1m个质数\033[0m");
        }
    }

    public static boolean isNum(String str) {
        for (int i = 0; i < str.length(); i++) {
            if (!Character.isDigit(str.charAt(i))) {
                return false;
            }
        }
        return true;
    }
}
