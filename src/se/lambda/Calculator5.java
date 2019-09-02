package se.lambda;

import java.util.Scanner;

public class Calculator5 {
    public static void main(String[] args) {
        while (true) {
            try {
                Scanner sc = new Scanner(System.in);
                String num = sc.nextLine();
                char[] chars = num.toCharArray();
                int index = 0;
                for (int i = 0; i < chars.length; i++) {

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
                       get(a);
                        break;
                    case '-':
                        double b = st1 - st2;
                        get(b);
                        break;
                    case '*':
                        double c = st1 * st2;
                        get(c);
                        break;
                    case '/':
                        double d = st1 / st2;
                        get(d);
                        break;
                }
            } catch (NumberFormatException e) {
                System.out.println("算式非法，重新输入");
            }
        }

    }
    //  判断数字是否以  .0  结尾
        public static void get(double num){
        String num1=num+" ";
        if (num1.endsWith(".0 ")){
            char[] chars = num1.toCharArray();
            int index = 0;
            for (int i = 0; i <chars.length; i++) {
                    if (chars[i] ==46) {
                        index = i;
                    }
                }
            String substring = num1.substring(0, index);
            int i = Integer.parseInt(substring);
            System.out.println(i);

        }else {
            System.out.println(num);
        }
    }
}
