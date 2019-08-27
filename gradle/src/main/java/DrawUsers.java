import POJO.User;

import java.util.ArrayList;
import java.util.Collections;

public class DrawUsers {

    // DrawUsers needs clone the create users list
    // Shuffle that list
    // and then match up in order
    // will add functionality for self later

    public static ArrayList<User> shuffleList() {
        ArrayList<User> shuffledUsers = (ArrayList<User>)CreateUsers.userList.clone();
        Collections.shuffle(shuffledUsers);

        for (int i = 0; i<shuffledUsers.size(); i++) {
            boolean self = notSelf(CreateUsers.userList.get(i),shuffledUsers.get(i));
            if (self) {
                CreateUsers.userList.get(i).setBuyingFor(shuffledUsers.get(i));
            } else {
                if (i == shuffledUsers.size()-1) {
                    CreateUsers.userList.get(i).setBuyingFor(shuffledUsers.get(i-1));
                    CreateUsers.userList.get(i-1).setBuyingFor(shuffledUsers.get(i));
                } else {
                    Collections.swap(shuffledUsers, i, i+1);
                    CreateUsers.userList.get(i).setBuyingFor(shuffledUsers.get(i));
                }
            }
        }
        return shuffledUsers;
    }

    public static boolean notSelf(User u1, User u2) {
        if (u1.equals(u2)) {
            return false;
        }
        return true;
    }


}
