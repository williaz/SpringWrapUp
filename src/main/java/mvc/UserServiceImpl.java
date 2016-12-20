package mvc;

import org.springframework.stereotype.Service;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by williaz on 12/19/16.
 */
@Service("service")
public class UserServiceImpl implements UserService {
    private Path data = Paths.get("src/main/resources/users.txt");
    private Map<Long, User> userCache = new HashMap<>();

    public boolean isValidUser(long id, String password) {
        renewCache();
        if (userCache.containsKey(id) && password.equals(userCache.get(id).getPassword())) return true;
        else return false;
    }

    public boolean addUser(User user) {
        if (isValidUser(user.getId(), user.getPassword())) return false;
        int err = 0;
        // overwrite to update
        try(ObjectOutputStream out = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(data.toFile())))) {
            for (User u : userCache.values()) {
                out.writeObject(u);
            }
            out.writeObject(user);
        } catch (FileNotFoundException e) {
            err = 1;
            //e.printStackTrace();
        } catch (IOException e) {
            err = 2;
            //e.printStackTrace();
        }
        if (err == 0) return true;
        else return false;

    }

    public long getPhoneNumber(long id) {
        renewCache();
        if (userCache.containsKey(id)) {
            return userCache.get(id).getPhoneNumber();
        }
        else return 0;
    }

    public User getUser(long id) {
        renewCache();
        if (userCache.containsKey(id)) {
            return userCache.get(id);
        }
        else return null;
    }

    private void renewCache() {
        try (ObjectInputStream in = new ObjectInputStream(new BufferedInputStream(new FileInputStream(data.toFile())))) {
            while (true) {
                Object object = in.readObject();
                if (object instanceof User) {
                    User user = (User) object;
                    userCache.put(user.getId(), user);
                }
            }
        } catch (FileNotFoundException e) {
            //e.printStackTrace();
        } catch (IOException e) {
            //e.printStackTrace();
        } catch (ClassNotFoundException e) {
            //e.printStackTrace();
        }
    }


}
