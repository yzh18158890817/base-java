package se.lambda;

import java.util.Scanner;

public class Calculator1 {
    public static void main(String[] args) {
        while (true) {
            Scanner sc = new Scanner(System.in);
            String num = sc.nextLine();
            char[] chars = num.toCharArray();
            int index=0 ;
            boolean flag;
            for (int i = 0; i < chars.length; i++) {
                if (chars[i]<'0'|| chars[i]>'9'){
                    index = i;
                }
            }
            String s1 = " ";
            String s2 = " ";
            for (int i = 0; i < chars.length; i++) {
                if (i < index) {
                    s1 = s1 + chars[i];
                } else if (i > index) {
                    s2 = s2 + chars[i];
                }
            }
            double st1=Double.parseDouble(s1);
            double st2 = Double.parseDouble(s2);
                switch (chars[index]){
                    case '+':
                        System.out.println(st1+st2);
                        break;
                    case '-':
                        System.out.println(st1-st2);
                        break;
                    case '*':
                        System.out.println(st1*st2);
                        break;
                    case '/':
                        System.out.println(st1/st2);
                        break;
                }
            }

            /*if (operator.equals("+")){
                System.out.println(num1+"+"+num2+"="+get1(num1, num2));
            }else if (operator.equals("-")){
                System.out.println(num1+"-"+num2+"="+get2(num1, num2));
            }else if (operator.equals("*")){
                System.out.println(num1+"*"+num2+"="+get3(num1, num2));
            }else if (operator.equals("/")){
                System.out.println(num1+"/"+num2+"="+get4(num1, num2));
            }else {
                System.out.println("输入有误请重新输入");
            }*/

        }

    /*public static double get1(double a, double b) {

        return a+b;
    }

    public static double get2(double a, double b) {
        return a-b;
    }

    public static double get3(double a,double b) {
        return a*b;
    }

    public static double get4(double a,double b) {
        return a/b;
    }*/
    }
