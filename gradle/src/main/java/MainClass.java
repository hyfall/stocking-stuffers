import POJO.User;

import java.util.ArrayList;

public class MainClass {

    public static void main(String [] args) {
        CreateUsers.start();
        System.out.println("Shuffling users");
        ArrayList<User> usersWithBuying = DrawUsers.pickPeople();
        System.out.println("EmailingUsers");
        EmailUsers.setUp();
        EmailUsers.cycleList(usersWithBuying);

        for (int i=0; i<CreateUsers.userList.size(); i++) {
            System.out.println("Name: " + CreateUsers.userList.get(i).getName());
            System.out.println("Buying For: " + CreateUsers.userList.get(i).getBuyingFor().getName());
        }

    }

}
