package com.shdev.oukongli.java.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by ou_kongli on 2015/7/14.
 */
@Controller
public class HelloController {
    @RequestMapping("/hello")
    public String hello(@RequestParam(value = "username", defaultValue = "") String username,
                        Model model,
                        ModelMap modelMap) {
        modelMap.put("username", username);
        model.addAttribute("username", "123");
        return "hello";
    }
}
