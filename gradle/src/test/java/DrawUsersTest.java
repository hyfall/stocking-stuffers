import POJO.User;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;


public class DrawUsersTest {

    private DrawUsers drawUsers = new DrawUsers();
    String[] expectedEmptyBlockers = new String[]{"none"};
    String[] nonEmptyBlocker = new String[]{"Christy"};
    String[] multipleBlockers = new String[]{"Christy", "Emily", "Rachel"};
    User userOne = new User ("Christy", "email@example.com", expectedEmptyBlockers);
    User userTwo = new User ("Ashley", "ashley@example.com", expectedEmptyBlockers);
    User userThree = new User ("Emily", "emily@example.com", expectedEmptyBlockers);
    User userFour = new User ("Rachel", "rachel@example.com", nonEmptyBlocker);
    User userFive = new User ("Alex", "alex@example.com", multipleBlockers);

    @Test
    public void sameUserShouldReturnFalse(){
        assertFalse(drawUsers.notSelf(userOne, userOne));
    }

    @Test
    public void differentUserShouldReturnTrue(){
        assertTrue(drawUsers.notSelf(userOne, userTwo));
    }

    @Test
    public void secondListShouldBeSmaller() {
        // Just for use debugging
        CreateUsers.userList.add(userOne);
        CreateUsers.userList.add(userTwo);
        CreateUsers.userList.add(userThree);

        ArrayList<User> finalUsers = drawUsers.shuffleList();

        /*assertThat(finalUsers.get(0).getBuyingFor(), is(not(userThree)));
        assertThat(finalUsers.get(1).getBuyingFor(), is(not(userOne)));
        assertThat(finalUsers.get(2).getBuyingFor(), is(not(userTwo)));*/
    }

    @Test
    public void noNameInBlockerShouldReturnTrue(){
        assertTrue(drawUsers.notBlocker(userOne, userTwo));
        assertTrue(drawUsers.notBlocker(userFive, userTwo));
    }

    @Test
    public void nameInBlockerShouldReturnFalse(){
        assertFalse(drawUsers.notBlocker(userFour, userOne));
        assertFalse(drawUsers.notBlocker(userFive, userFour));
    }

}