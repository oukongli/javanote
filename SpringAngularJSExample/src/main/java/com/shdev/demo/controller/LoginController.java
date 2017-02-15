package com.shdev.demo.controller;

import com.shdev.demo.common.Constants;
import com.shdev.demo.common.Universe;
import com.shdev.demo.model.User;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;
import java.util.Locale;

/**
 * Created by ou_ko on 2017/2/15.
 */
@Controller
public class LoginController extends BaseController {
    private static final Logger logger = LoggerFactory.getLogger(LoginController.class);

    private static final String PASSWORD = "password";

    @RequestMapping(value = "/login", method = {RequestMethod.GET, RequestMethod.HEAD})
    public String login(@RequestParam(value = "url", defaultValue = "/home") String url, ModelMap modelMap) {
        modelMap.put("redirectUrl", url);
        if (!StringUtils.isEmpty(Universe.current().getSubject()))
            return "redirect:" + url;

        return "login";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(@RequestParam String email, @RequestParam String password, @RequestParam String url, final RedirectAttributes redirectAttributes, HttpSession httpSession) {
        String mail = email.toLowerCase(Locale.ENGLISH);
        try {
            if ("t@e.c".equals(mail) && "2".equals(password)) {
                User user = new User();
                user.setUserName(email);
                user.setPassword(password);
                httpSession.setAttribute(Constants.SUBJECT, user);
            }
        } catch (Exception ex) {
            redirectAttributes.addFlashAttribute("message", "error");
            return "redirect:/login";
        }

        return "redirect:/";
    }
}
