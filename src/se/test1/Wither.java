package se.test1;

import java.util.ArrayList;

public class Wither implements Filter {
    ArrayList<User> users;

    @Override
    public void filterUser() {
        for (int i = 0; i < users.size(); i++) {
            User a = users.get(i);
            if (a.id >= 10 && a.id <= 19) {
                a.setName("-V1");
            }if (a.id>=20 && a.id<=29){
                a.setName("-V2");
            }
        }
//        System.out.println(users);
        ArrayList<User> users1 = new ArrayList<>();
        ArrayList<User> users2 = new ArrayList<>();
        for (int i = 0; i < this.users.size(); i++) {
            User b= this.users.get(i);
            if (b.getName().equals("-V1")){
                users1.add(users.get(i));
            }if (b.getName().equals("-V2")){
                users2.add(users.get(i));
            }
        }
        for (int i = 0; i <users1.size(); i++) {
            User c=users1.get(i);
            System.out.println(c.id+c.name);
        }
        for (int i = 0; i < users2.size(); i++) {
            User d=users2.get(i);
            System.out.println(d.id+d.name);
        }
    }

    public Wither() {
    }

    public ArrayList<User> getUsers() {
        return users;
    }

    public void setUsers(ArrayList<User> users) {
        this.users = users;
    }
}
