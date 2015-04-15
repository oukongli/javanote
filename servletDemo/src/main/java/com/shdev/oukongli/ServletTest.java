package com.shdev.oukongli;

import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by ou_kongli on 2015/4/13.
 */
public class ServletTest extends javax.servlet.http.HttpServlet {
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {

    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        int nums = 0;
        try {
            nums = Integer.parseInt(request.getParameter("times"));

        } catch (Exception e) {
        }
        response.setContentType("text/html");
        PrintWriter pw = response.getWriter();
        pw.println("<html><body>");
        for (int i = 0; i < nums; i++) {
            pw.println("hello" + i + "<br>");
        }
        pw.println("</body></html>");
    }
}
