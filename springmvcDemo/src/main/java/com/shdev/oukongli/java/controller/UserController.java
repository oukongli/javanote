package com.shdev.oukongli.java.controller;

import com.shdev.oukongli.java.exception.MyException;
import com.shdev.oukongli.java.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by ou_kongli on 2015/7/14.
 */
@Controller
@RequestMapping("/user")
public class UserController {
    private Map<String, User> users = new HashMap<String, User>(){{
        put("user1", new User(1, "user1", "user1"));
        put("user2", new User(2, "user2", "user2"));
        put("user3", new User(3, "user3", "user3"));
        put("user4", new User(4, "user4", "user4"));
        put("user5", new User(5, "user5", "user5"));
    }};

    @RequestMapping(value = "/users", method = RequestMethod.GET)
    public String list(ModelMap modelMap) {
        modelMap.put("users", users);
        return "user/list";
    }

    @RequestMapping(value = "/{username}", method = RequestMethod.GET)
    public String show(@PathVariable String username, ModelMap modelMap) {
        modelMap.put("user", users.get(username));
        return "user/show";
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login() {
        return "user/login";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(@RequestParam(value = "name") String username, String password, ModelMap modelMap) {
        return "redirect:/user/users";
    }


    @RequestMapping("exception")
    public void getException() {
        throw new MyException("test");
    }
}
