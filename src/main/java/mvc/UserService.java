package mvc;

import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by williaz on 12/19/16.
 */
public interface UserService {
    public boolean isValidUser(long id, String password);
    public boolean addUser(User user);
    public long getPhoneNumber(long id);
    public User getUser(long id);
}
