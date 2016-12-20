import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import mvc.User;
import mvc.UserService;

import static org.junit.Assert.*;

/**
 * Created by williaz on 12/19/16.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:./web/WEB-INF/applicationContext.xml"})
public class UserServiceTest {
    @Autowired
    private UserService service;

    @Test
    public void test_AddUser() {
        //User user = new User(100, "Will", "1234", 7321231234L);
       // assertTrue(service.addUser(user));
    }

    @Test
    public void test_IsValidUser() {
        //User user = new User(101, "Bill", "b214", 7321231784L);
        //assertTrue(service.addUser(user));
        assertTrue(service.isValidUser(101, "b214"));
        assertTrue(service.isValidUser(100, "1234"));
    }

    @Test
    public void test_GetPhoneNumber() {
        //User user = new User(102, "Calvin", "c214", 7321881784L);
        //assertTrue(service.addUser(user));
        assertEquals(7321881784L, service.getPhoneNumber(102));
    }

    @Test
    public void test_GetUser() {
        User user = new User(102, "Calvin", "c214", 7321881784L);
        assertEquals(user, service.getUser(102));
    }


}
