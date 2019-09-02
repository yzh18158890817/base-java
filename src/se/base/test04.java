package se.base;


import java.util.*;

public class test04 {
    public static void main(String[] args) {
        //  创建HashMap 集合  保存数据
        HashMap<String, String> map = new HashMap<>();
        while (true) {
            try {
                //  输入数据f
                Scanner sc = new Scanner(System.in);
                System.out.println("请输入用户名");
                String name = sc.nextLine();
                System.out.println("请输入所修心法");
                String xinfa=sc.nextLine();
                // 保存数据到HashMap  集合
                map.put(name,xinfa);

                // get方法判断是否存在，如果存在异常被try--catch 捕捉
                //   不存在则注册成功 ，并且保存到HashMap
                get(map,name,xinfa);
                System.out.println("注册成功");
            }

            catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }
    public static void get(HashMap map,String name,String xifa) throws ChongMingLe {
        Set<String> keys = map.keySet();
        for (String n : keys) {
            String x = (String) map.get(n);
            if ( n.equals(name) && x.equals(xifa) ) {
                throw new ChongMingLe("已经有了");
            }
           // boolean b = map.containsKey();
        }
        }
    }

