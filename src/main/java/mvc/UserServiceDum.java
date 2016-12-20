package mvc;

import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by williaz on 12/19/16.
 */
@Service("dummy")
public class UserServiceDum implements UserService {
    private Map<Long, User> userCache = new HashMap<>();
    {
        User user1 = new User(100, "Will", "w123", 7321231234L);
        User user2 = new User(101, "Bill", "b123", 7321991234L);
        User user3 = new User(102, "Calvin", "c123", 7321237734L);
        userCache.put(100L, user1);
        userCache.put(101L, user2);
        userCache.put(102L, user3);
    }

    @Override
    public boolean isValidUser(long id, String password) {
        if (userCache.containsKey(id) && password.equals(userCache.get(id).getPassword())) return true;
        else return false;
    }

    @Override
    public boolean addUser(User user) {
        if (isValidUser(user.getId(), user.getPassword())) return false;
        userCache.put(user.getId(), user);
        return true;
    }

    @Override
    public long getPhoneNumber(long id) {
        if (userCache.containsKey(id)) return userCache.get(id).getPhoneNumber();
        else return 0;
    }

    @Override
    public User getUser(long id) {
        if (userCache.containsKey(id)) return userCache.get(id);
        else return null;
    }
}
