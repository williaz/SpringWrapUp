package mvc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by williaz on 12/19/16.
 */
@Controller
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService service;

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(@ModelAttribute User user) {
        if (service.isValidUser(user.getId(), user.getPassword())) {
            return "home";
        } else {
            return "error";
        }
    }


}
