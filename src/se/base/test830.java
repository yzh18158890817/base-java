package se.base;

import java.util.*;
import java.util.stream.Collectors;

public class test830 {
    public static void main(String[] args) {
        HashMap<Integer, String> map = new HashMap<>();
        map.put(1, "北傲决");
        map.put(2, "笑尘决");
        map.put(3, "分山劲");
//        System.out.println(map.put(2, "笑尘决"));
//        System.out.println(map.put(3, "分山劲"));
        System.out.println(map);


        System.out.println(map.keySet());
        //  这里可以用Set集合

//        for (Integer s : keySet) {
//            System.out.println(s);
//        }
        List<String> list = map.values().stream().collect(Collectors.toList());
        Set<String> set = map.values().stream().collect(Collectors.toSet());
        System.out.println(list);
        System.out.println(set);
        // 这里为什么非要用Collection集合
        //   为什么不可以用   Set<String> values = map.values();
        //  或者List <String> values = map.values();
//        for (String str : values) {
//            System.out.println(str);
//        }


        //   第一种遍历集合方式
        // for (Integer s:keySet){
        //    String v=map.get(s);
        //    System.out.println(v);
        //}
        //   第二种遍历集合方式
//        Set<Map.Entry<Integer, String>> entries = map.entrySet();
//        for (Map.Entry<Integer, String> entry : entries) {
//            Integer key = entry.getKey();
//            String v = entry.getValue();
//            System.out.println(key + " " + v);
//        }
    }
}


