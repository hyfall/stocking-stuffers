import POJO.User;

import java.util.ArrayList;
import java.util.Scanner;

public class CreateUsers {

    public static ArrayList<User> userList = new ArrayList<User>();

    public static void start() {
        int n = 0;
        Scanner keyboard = new Scanner(System.in);
        while (n != -1) {
            System.out.println("What's your name?");
            String name = keyboard.nextLine();
            System.out.println("What's your email");
            String email = keyboard.nextLine();
            System.out.println("Anyone you can't buy for? Please separate by commas");
            String blockers = keyboard.nextLine();
            newUser(name, email, blockers);
            System.out.println("Another one? Enter 0 to continue and -1 to quit");
            n = keyboard.nextInt();
            keyboard.nextLine();
            if (n == -1 && userList.size() < 3) {
                System.out.println("Need at least 3 People in Drawing");
                n = 0;
            }
        }
    }

    public static void newUser(String n, String e, String b) {
        String[] blockers = parseBlockers(b);
        User addUser = new User (n, e, blockers);
        userList.add(addUser);
    }

    public static String[] parseBlockers(String list) {
        String[] blockers = list.split(", ");
        return blockers;
    }

}
