package mvc;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

/**
 * Created by williaz on 12/19/16.
 */
@Controller
@RequestMapping("/users")
public class UserController {
    @Autowired
    @Qualifier("dummy")
    private UserService service;

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String excuteLogin(@ModelAttribute User user, HttpSession session) {
        if (service.isValidUser(user.getId(), user.getPassword())) {
            user = service.getUser(user.getId());
            session.setAttribute("user", user);
            return "home"; //first direct, miss name!
        } else {
            return "error";
        }
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public ModelAndView loginPage() {
        return new ModelAndView("login", "user", new User());
    }

    @RequestMapping(value = "/profile", method = RequestMethod.GET)
    public String profilePage(HttpSession session) {
        Object object = session.getAttribute("user");
        User user = null;
        if (object instanceof User)
            user = (User) object;
        //return new ModelAndView("profile", "user", user);
        return "profile";
    }

    @RequestMapping(value = "/home", method = RequestMethod.GET)
    public String homePage() {
        return "home";
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String excuteRegister(@ModelAttribute User user, HttpSession session) {
        if (service.isValidUser(user.getId(), user.getPassword())) return "error";
        else {
            service.addUser(user);
            session.setAttribute("user", user);
            return "home";
        }
    }

    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public ModelAndView registerPage() {
        return new ModelAndView("register", "user", new User());
    }


}
