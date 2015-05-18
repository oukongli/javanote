package com.shdev.oukongli.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Created by ou_kongli on 2015/5/15.
 */
public class BaseServlet extends HttpServlet {
    private String prefix = "redirect:";

    @Override
    public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            request.setCharacterEncoding("utf-8");
            String methodName = request.getParameter("method");
            Method method = this.getClass().getMethod(methodName, HttpServletRequest.class, HttpServletResponse.class);
            String url = (String)method.invoke(this, request, response);
            if (url.startsWith(prefix)) {
                response.sendRedirect(url.substring(prefix.length()));
            } else {
                request.getRequestDispatcher(url).forward(request, response);
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
