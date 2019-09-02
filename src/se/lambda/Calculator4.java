package se.lambda;

import java.util.Scanner;

public class Calculator4 {
    public static void main(String[] args) {
        while (true) {
            try {
                Scanner sc = new Scanner(System.in);
                String num = sc.nextLine();
                char[] chars = num.toCharArray();
                int index = 0;
                for (int i = 0; i < chars.length; i++) {
                    /*if (chars[i]<42){
                        System.out.println("输入类型不正确，重新输入");
                        break;
                    }*/
                    if (chars[i] < '0' || chars[i] > '9') {
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
                double st1 = Double.parseDouble(s1);
                double st2 = Double.parseDouble(s2);
                switch (chars[index]) {
                    case '+':
                        double a = st1 + st2;
                        if (a % 10 == 0) {
                            int a1 = (int) a;
                            System.out.println(a1);
                        } else {
                            System.out.println(a);
                        }
                        break;
                    case '-':
                        double b = st1 - st2;
                        if (b % 10 == 0) {
                            int b1 = (int) b;
                            System.out.println(b1);
                        } else {
                            System.out.println(b);
                        }
                        break;
                    case '*':
                        double c = st1 * st2;
                        if (c % 10 == 0) {
                            int c1 = (int) c;
                            System.out.println(c1);
                        } else {
                            System.out.println(c);
                        }
                        break;
                    case '/':
                        double d = st1/st2;
                        if (d % 10 == 0) {
                            int d1 = (int)d;
                            System.out.println(d1);
                        } else {
                            System.out.println(d);
                        }
                        break;
                }
            } catch (NumberFormatException e) {
                System.out.println("算式非法，重新输入");
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
