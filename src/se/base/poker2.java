package se.base;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class poker2 {
    public static void main(String[] args) {
        String[] num = {"A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K"};
        String[] color = {"♥", "♠", "♦", "♣"};
        HashMap<Integer, String> poker = new HashMap<>();
        ArrayList<String> list = new ArrayList<>();
        ArrayList<Integer> s = new ArrayList<>();
        //  完成扑克牌一一对应关系
        String p = null;
        Integer index = 1;
        for (String c : color) {
            for (String n : num) {
                p = c + n;
                list.add(p);
                s.add(index);
                index += 1;
            }
        }
        //s.add(53);
        //s.add(54);
        for (int i = 1; i < 53; i++) {
            poker.put(s.get(i - 1), list.get(i - 1));
        }
        s.add(53);
        s.add(54);
        list.add("小王");
        list.add("大王");
        poker.put(53, "小王");
        poker.put(54, "大王");
        System.out.println("索引" + s.size());
        System.out.println("洗牌前" + poker);

        // 洗牌
        Collections.shuffle(s);
        for (int i = 1; i < 55; i++) {
            poker.put(s.get(i - 1), list.get(i - 1));
        }
            //poker.put(53, "小王");
            //poker.put(54, "大王");
            System.out.println("洗牌后"+poker);
            ArrayList<String> Player1 = new ArrayList<>();//1  4  7
            ArrayList<String> Player2 = new ArrayList<>();//2  5   8
            ArrayList<String> Player3 = new ArrayList<>();//3  6   9
            ArrayList<String> dipai = new ArrayList<>();
            //发牌
            for (int i= 1; i <= s.size(); i++) {
                if (i <= 51) {
                    switch (i % 3) {
                        case 0:
                            Player1.add(poker.get(i));
                            break;

                        case 1:
                            Player2.add(poker.get(i));
                            break;

                        case 2:
                            Player3.add(poker.get(i));
                            break;
                    }
                } else {
                    dipai.add(poker.get(i));
                }
            }
            System.out.println("燕帅：" + Player1);
            System.out.println("柳夕：" + Player2);
            System.out.println("叶英：" + Player3);
            System.out.println("底牌：" + dipai);
        }

    }
