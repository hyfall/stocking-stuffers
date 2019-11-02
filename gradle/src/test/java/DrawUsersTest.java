import POJO.User;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;


public class DrawUsersTest {

    private DrawUsers drawUsers = new DrawUsers();
    String[] expectedEmptyBlockers = new String[]{"none"};
    String[] nonEmptyBlocker = new String[]{"Christy"};
    String[] multipleBlockers = new String[]{"Christy", "Ashley", "Rachel"};
    User userOne = new User ("Christy", "email@example.com", expectedEmptyBlockers);
    User userTwo = new User ("Ashley", "ashley@example.com", expectedEmptyBlockers);
    User userThree = new User ("Emily", "emily@example.com", expectedEmptyBlockers);
    User userFour = new User ("Rachel", "rachel@example.com", nonEmptyBlocker);
    User userFive = new User ("Alex", "alex@example.com", multipleBlockers);

    @Test
    public void secondListShouldBeSmaller() {
        // Just for use debugging
        CreateUsers.userList.add(userOne);
        CreateUsers.userList.add(userTwo);
        CreateUsers.userList.add(userThree);
        CreateUsers.userList.add(userFour);
        CreateUsers.userList.add(userFive);

        ArrayList<User> finalUsers = drawUsers.pickPeople();
        for (int i = 0; i<finalUsers.size(); i++) {
            User user = finalUsers.get(i);
            System.out.println(user.getName() + " is buying for " + user.getBuyingFor().getName());
        }

    }

    @Test
    public void nameInBlockerShouldReturnTrue(){
        assertTrue(drawUsers.notBlocker(userOne, userTwo));
        assertTrue(drawUsers.notBlocker(userFive, userThree));
    }

    @Test
    public void nameInBlockerShouldReturnFalse(){
        assertFalse(drawUsers.notBlocker(userFour, userOne));
        assertFalse(drawUsers.notBlocker(userFive, userFour));
    }

    @Test
    public void alexShouldBeFirst() {
        CreateUsers.userList.add(userOne);
        CreateUsers.userList.add(userTwo);
        CreateUsers.userList.add(userThree);
        CreateUsers.userList.add(userFour);
        CreateUsers.userList.add(userFive);

        ArrayList<User> finalUsers = drawUsers.blockersAtFront(CreateUsers.userList);
        assertThat(finalUsers.get(0), is(userFive));
    }

}