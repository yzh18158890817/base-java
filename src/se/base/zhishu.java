package se.base;

import java.util.Scanner;

/* 1.键盘输入一个自然数；
   2.找出范围内的质数
 */

public class zhishu {
    public static void main(String[] args) {
        zhishu();//  调用第三个方法

    }

    public static int fanWei() {  // 创建第一个方法，键盘输入一个自然数
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入一个整数，大于1");
        while (true) {
            int num = sc.nextInt();
            if (num <= 0) {
                System.out.println("你个憨憨，输入错误，请重新输入");
            } else {
                return num;
            }
        }
    }

    public static int ciShu() {  //  创建第二个方法 ，调用第一个方法，找出范围内 只有两个因数的自然数
        int a = 0;
        for (int i = 1; i <=fanWei(); i++) {
            for (int j = 1; j < i; j++) {
                if (i % j == 0) {
                    a += 1;
                }
            }
        }
        return a;
    }

    public static void zhishu() {// 创建第三个方法  调用第一个和第二个方法，找出只有两个因数的是哪些值
        for (int i = 1; i <= fanWei(); i++) {
            // 调用第二个方法
            if (ciShu() == 2) {
                System.out.println(i);
            }
        }
    }
}
