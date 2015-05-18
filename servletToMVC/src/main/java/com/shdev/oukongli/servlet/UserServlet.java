package com.shdev.oukongli.servlet;

import com.shdev.oukongli.model.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by ou_kongli on 2015/5/15.
 */
public class UserServlet extends BaseServlet {
    public String add(HttpServletRequest request, HttpServletResponse response) {
        String username = request.getParameter("username");
        String nickname = request.getParameter("nickname");
        int age = Integer.parseInt(request.getParameter("age"));
        List<User> users = (List<User>) request.getSession().getServletContext().getAttribute("users");
        if (users == null) {
            users = new ArrayList<User>();
        }
        users.add(new User(username, nickname, age));
        request.getSession().getServletContext().setAttribute("users", users);
        return "redirect:/user?method=list";
    }

    public String list(HttpServletRequest request, HttpServletResponse response) {
        return "user/list.jsp";
    }

    public String register(HttpServletRequest request, HttpServletResponse response) {
        return "user/add.jsp";
    }
}
