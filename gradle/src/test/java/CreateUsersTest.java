import POJO.User;
import org.junit.Test;
import static org.hamcrest.CoreMatchers.*;

import static org.junit.Assert.*;

public class CreateUsersTest {

    private CreateUsers createUsers = new CreateUsers();
    String[] expectedBlockerArray = new String[]{"Jane", "Erin"};
    String[] expectedEmptyBlockers = new String[]{"none"};
    User expectedUserNoBlocker = new User ("Christy", "email@example.com", expectedEmptyBlockers);
    User expectedUserWithBlocker = new User ("Christy", "email@example.com", expectedBlockerArray);

    @Test
    public void shouldAddOneUserToArray() {
        createUsers.newUser("Christy", "email@example.com", "none");

        assertThat(CreateUsers.userList.size(),is(1));
        assertTrue(CreateUsers.userList.contains(expectedUserNoBlocker));
    }

    @Test
    public void shouldAddUserWithBlockerToArray() {
        createUsers.newUser("Christy", "email@example.com", "Jane, Erin");
        assertTrue(CreateUsers.userList.contains(expectedUserWithBlocker));
    }

    @Test
    public void shouldTakeStringAndReturnArray(){
        String[] actualList = createUsers.parseBlockers("Jane, Erin");
        assertTrue(expectedBlockerArray[0].equals(actualList[0]));
        assertTrue(expectedBlockerArray[1].equals(actualList[1]));

    }

}