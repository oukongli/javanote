package com.shdev.demo.controller;

import com.shdev.demo.common.DataSourceType;
import com.shdev.demo.common.DynamicDataSourceHolder;
import com.shdev.demo.model.User;
import com.shdev.demo.service.def.UserService;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;


@Controller
@RequestMapping("/users")
public class UserController extends BaseController {
    private static Logger logger = Logger.getLogger(UserController.class);

    @Resource
    private UserService userService;

    @RequestMapping("/userlist.json")
    @ResponseBody
    public List<User> getUserList(@RequestParam(value = "ywlsh", defaultValue = StringUtils.EMPTY) String ywlsh,
                                  @RequestParam(defaultValue = StringUtils.EMPTY) String jylsh) throws Exception {
        if (ywlsh.equals("0"))
            DynamicDataSourceHolder.setDataSourceType((DataSourceType) null);
        if (ywlsh.equals("1"))
            DynamicDataSourceHolder.setDataSourceType("oracle");
        if (ywlsh.equals("2"))
            DynamicDataSourceHolder.setDataSourceType("mysql");
        if (ywlsh.equals("error"))
            throw new Exception("test exception");
        logger.info(ywlsh);
        logger.info(jylsh);
        logger.info("get user list");
        return userService.getAllUsers();
    }

    @RequestMapping(value = "/addUser/{userName}", method = RequestMethod.POST)
    @ResponseBody
    public void addUser(@PathVariable("userName") String userName) {
        userService.addUser(userName);
    }

    @RequestMapping(value = "/removeUser/{userName}", method = RequestMethod.DELETE)
    @ResponseBody
    public void removeUser(@PathVariable("userName") String userName) {
        userService.deleteUser(userName);
    }

    @RequestMapping(value = "/removeAllUsers", method = RequestMethod.DELETE)
    @ResponseBody
    public void removeAllUsers() {
        userService.deleteAll();
    }

    @RequestMapping("/layout")
    public String getUserPartialPage() {
        return "users/layout";
    }

}
