import POJO.User;

import java.util.ArrayList;

public class CreateUsers {

    public static ArrayList<User> userList = new ArrayList<User>();

    public void start() {
        // Keyboard gets input - name, email, blockers
        // should create a new user
    }

    public void newUser(String n, String e, String b) {
        if (b.compareToIgnoreCase("none") == 0) {
            User addUser = new User(n, e);
            userList.add(addUser);
        } else {
            User addUser = new User (n, e, b);
            userList.add(addUser);
        }
    }
}
