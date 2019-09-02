package se.test1;

import java.util.ArrayList;
import java.util.Random;

public class test {
    public static void main(String[] args) {
        Wither wither = new Wither();
        ArrayList<User> users8 = new ArrayList<>();
        Random r = new Random();
        for (int i = 0; i < 50; i++) {
            int num = r.nextInt(50) + 1;
            User user = new User(num, "-A");
            users8.add(user);
        }
        wither.setUsers(users8);
        wither.filterUser();
    }
}
