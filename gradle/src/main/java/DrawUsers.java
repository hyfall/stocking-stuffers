import POJO.User;

import java.util.ArrayList;
import java.util.Collections;

public class DrawUsers {

    // DrawUsers needs clone the create users list
    // Shuffle that list
    // and then match up in order
    // will add functionality for self later

    public static void shuffleList() {
        ArrayList<User> shuffledUsers = (ArrayList<User>)CreateUsers.userList.clone();
        Collections.shuffle(shuffledUsers);

        for (int i = 0; i<shuffledUsers.size(); i++) {
            CreateUsers.userList.get(i).setBuyingFor(shuffledUsers.get(i));
        }

    }

    public boolean notSelf(User u1, User u2) {
        if (u1.equals(u1)) {
            return false;
        }
        return true;
    }


}
