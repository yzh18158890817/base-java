package se.base;

import java.util.*;
import java.util.stream.Collectors;

public class poker {
    public static void main(String[] args) {
        String[] num = {"A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K"};
        String[] color = {"♥", "♠", "♦", "♣"};
        Map<Integer, String> map = new HashMap<>();
        //  完成扑克牌一一对应关系
        int index = 1;
        for (String c : color) {
            for (String n : num) {
                map.put(index, c + n);
                index++;
            }
        }
        map.put(53, "小王");
        map.put(54, "大王");
        // 洗牌
        List<Integer> list = map.keySet().stream().collect(Collectors.toList());
        Collections.shuffle(list);
        for (int i = 0; i < list.size(); i++) {
            map.put(i, map.get(list.get(i)));
        }
        ArrayList<String> Player1 = new ArrayList<>();//1  4  7
        ArrayList<String> Player2 = new ArrayList<>();//2  5   8
        ArrayList<String> Player3 = new ArrayList<>();//3  6   9
        ArrayList<String> dipai = new ArrayList<>();
        //发牌
        for (int i = 1; i <= 54; i++) {
            if (i <= 51) {
                switch (i % 3) {
                    case 0:
                        Player1.add(map.get(i));
                        break;
                    case 1:
                        Player2.add(map.get(i));
                        break;
                    case 2:
                        Player3.add(map.get(i));
                        break;
                }
            } else {
                dipai.add(map.get(i));
            }
        }
        System.out.println("燕帅：" + Player1);
        System.out.println("柳夕：" + Player2);
        System.out.println("叶英：" + Player3);
        System.out.println("底牌：" + dipai);
    }
}
