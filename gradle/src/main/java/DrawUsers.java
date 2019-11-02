import POJO.User;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class DrawUsers {

    public static ArrayList<User> pickPeople() {
        Random rand = new Random();
        ArrayList<User> orderedUsers = blockersAtFront(CreateUsers.userList);

        for (int i=0; i<orderedUsers.size(); i++) {
            User userPicking = orderedUsers.get(0);
            int random = rand.nextInt(orderedUsers.size()-1) + 1;
            User randUser = orderedUsers.get(random);
            boolean aBlockerQ = notBlocker(userPicking, randUser);
            while(randUser.isPicked() || !aBlockerQ) {
                random = rand.nextInt(orderedUsers.size()-1) + 1;
                randUser = orderedUsers.get(random);
                aBlockerQ = notBlocker(userPicking, randUser);
            }
            userPicking.setBuyingFor(randUser);
            randUser.setPicked(true);
            orderedUsers.remove(0);
            orderedUsers.add(userPicking);
        }

        return orderedUsers;
    }

    // should return false if blocker
    // should return true if not blocker
    public static boolean notBlocker(User u1, User u2) {
        // u1 is user, u2 we are checking if in blockers
        String[] blockers = u1.getBlockers();
        for (int i=0; i<blockers.length; i++) {
            if (blockers[i].equals(u2.getName())){
                return false;
            }
        }
        return true;
    }

    public static ArrayList<User> blockersAtFront(ArrayList<User> given) {
        ArrayList<User> orderedUsers = new ArrayList<>();
        ArrayList<Integer> numOfBlockers = new ArrayList<>();
        orderedUsers.add(given.get(0));
        int length = given.get(0).getBlockers().length;
        if (given.get(0).getBlockers()[0].equalsIgnoreCase("none")) {
            length = 0;
        }
        numOfBlockers.add(length);
        given.remove(0);
        while (given.size()!= 0) {
            length = given.get(0).getBlockers().length;
            if (given.get(0).getBlockers()[0].equalsIgnoreCase("none")) {
                length = 0;
            }
            for (int i = 0; i<orderedUsers.size(); i++) {
                if (length>numOfBlockers.get(i)) {
                    orderedUsers.add(i, given.get(0));
                    numOfBlockers.add(i, length);
                    given.remove(0);
                    break;
                } else if (i == orderedUsers.size()-1) {
                    orderedUsers.add(given.get(0));
                    numOfBlockers.add(length);
                    given.remove(0);
                    break;
                }
            }
        }
        return orderedUsers;
    }

}
