package com.shdev.oukongli.java.controller;

import com.shdev.oukongli.java.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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
}
