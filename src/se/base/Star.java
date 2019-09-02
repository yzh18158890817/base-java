package se.base;

import java.util.ArrayList;
import java.util.Scanner;

public class Star {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        String num;
        for (int i = 0; i <9; i++) {
            System.out.println("按con继续打印，按esc结束");
            num = sc.next();
            list.add(num);
            for (int a = 0; a< list.size(); a++) {
                String s = list.get(a);
                if (s.equals("esc")) {
                    break;
                } else if (s.equals("con")) {
                    for (int j = 0; j <=i; j++){
                        System.out.print("*");
                    }
                }
            }
            System.out.println(" ");
        }
    }
}