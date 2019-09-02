package se.lambda;

import java.util.Random;
import java.util.Scanner;

public class Test042 {
    public static void main(String[] args) {
        Random r = new Random();
        //Scanner sc = new Scanner(System.in);
        int num=0;
        while (true){
            int a = r.nextInt(100)+1;
            int b=r.nextInt(100)+1;
            num+=1;
           // System.out.println("输入1-100随机数");
            //int j=sc.nextInt();
            if (a==b){
                System.out.println(a);
                System.out.println(b);
                System.out.println("侠士通过"+num+"次努力获得踏炎乌骓，恭喜欧皇");
                break;
            }else {
                System.out.println("第"+num+"次刷本，没出哦，继续努力");
            }
        }
    }
}
