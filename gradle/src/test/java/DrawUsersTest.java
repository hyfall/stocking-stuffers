import POJO.User;
import org.junit.Test;

import static org.junit.Assert.*;

public class DrawUsersTest {

    private DrawUsers drawUsers = new DrawUsers();
    User userOne = new User ("Christy", "email@example.com");
    User userTwo = new User ("Ashley", "ashley@example.com");

    @Test
    public void sameUserShouldReturnFalse(){
        assertFalse(drawUsers.notSelf(userOne, userOne));
    }


}