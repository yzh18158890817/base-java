package se.lambda;

public class Test14 {
    private static Integer calc;

    public static void main(String[] args) {
       /* 2.在测试类中定义static void getProduct(int a , int b ,IntCalc calc),
        该方法的预期行为是使用calc得到a和b的乘积并打印结果
        3.测试getProduct(),通过lambda表达式完成需求*/
        int a = 5;
        int b = 5;
        getCalc(a, b, new Test14_IntCalc() {
            @Override
            public void calc(int a, int b) {
                System.out.println(a*b);
            }
        });
    }

    public static void getCalc(int a,int b,Test14_IntCalc test14_intCalc) {
         test14_intCalc.calc(a,b);
    }
}
