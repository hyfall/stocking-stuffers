import POJO.User;
import org.junit.Test;

import static org.junit.Assert.*;

public class DrawUsersTest {

    private DrawUsers drawUsers = new DrawUsers();
    String[] expectedEmptyBlockers = new String[]{"none"};
    User userOne = new User ("Christy", "email@example.com", expectedEmptyBlockers);
    User userTwo = new User ("Ashley", "ashley@example.com", expectedEmptyBlockers);

    @Test
    public void sameUserShouldReturnFalse(){
        assertFalse(drawUsers.notSelf(userOne, userOne));
    }

    @Test
    public void differentUserShouldReturnTrue(){
        assertFalse(drawUsers.notSelf(userOne, userTwo));
    }

}