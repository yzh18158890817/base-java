package se.base;

import se.base.Humen;

public class Student extends Humen {
    // 成员方法
    @Override
    public void eat() {
        System.out.println("吃学生餐");
    }

    private void study() {
        System.out.println("学习");
    }

    public Student() {
//        System.out.println("32165156165");
    }
}
