package system.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import system.model.User;
import system.service.UserServiceImpl;

import java.util.List;

/**
 * Created by Administrator on 18.10.2017.
 */
@Controller
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserServiceImpl userService;

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public @ResponseBody
    List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @RequestMapping(value = "/validate", method = RequestMethod.GET)
    public ModelAndView validateUser() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("userFromServer", new User("login", "password"));
        modelAndView.setViewName("users_check_page");
        return modelAndView;
    }

    @RequestMapping(value = "/check", method = RequestMethod.POST)
    public @ResponseBody
    ModelAndView checkUser(@ModelAttribute("userFromServer") User user) {
        ModelAndView modelAndView = new ModelAndView();
        if (userService.checkUser(user)) {
            modelAndView.setViewName("valid");
        } else {
            modelAndView.setViewName("invalid");
        }

        return modelAndView;
    }
}

