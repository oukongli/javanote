package com.oukongli.web;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Created by ou_kongli on 2015/5/19.
 */
public class BaseServlet extends HttpServlet {
    private final static String REDIRPATH = "redirect";
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            String methodName = req.getParameter("method");
            Method method = this.getClass().getMethod(methodName, HttpServletRequest.class, HttpServletResponse.class);
            String path = (String)method.invoke(this, req, resp);
            if (path.startsWith(REDIRPATH)) {
                resp.sendRedirect(path.substring(REDIRPATH.length()));
            } else {
                req.getRequestDispatcher(path).forward(req, resp);
            }
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}
