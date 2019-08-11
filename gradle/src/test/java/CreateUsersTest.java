import POJO.User;
import org.junit.Test;
import static org.hamcrest.CoreMatchers.*;

import static org.junit.Assert.*;

public class CreateUsersTest {

    private CreateUsers createUsers = new CreateUsers();
    User expectedUserNoBlocker = new User ("Christy", "email@example.com");
    User expectedUserWithBlocker = new User ("Christy", "email@example.com", "Jane");

    @Test
    public void shouldAddOneUserToArray() {
        createUsers.newUser("Christy", "email@example.com", "None");

        assertThat(CreateUsers.userList.size(),is(1));
        assertTrue(CreateUsers.userList.contains(expectedUserNoBlocker));
    }

    @Test
    public void shouldAddUserWithBlockerToArray() {
        createUsers.newUser("Christy", "email@example.com", "Jane");
        assertTrue(CreateUsers.userList.contains(expectedUserWithBlocker));
    }

}