package se.base;

import java.awt.geom.Ellipse2D;
import java.util.Scanner;

public class prime {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("输入大于1的任意自然数");
        int num = 0;
        num = sc.nextInt();
        System.out.println("0到" + num + "之间的所有质数为：");
        int b=0;
        for (int i = 2; i <= num; i++) {
            int a = 0;
            for (int j = 2; j < i; j++) {
                if (i % j == 0) {
                    a += 1;
                }
                }
                if (a == 0) {
                b+=1;
                System.out.print(i + "，");
            }
        }
        System.out.println(" ");
        System.out.println("一共"+b+"个质数");
    }
}
