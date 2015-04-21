package com.shdev.oukongli.filter;

import com.shdev.oukongli.model.User;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by ou_kongli on 2015/4/21.
 */
@WebFilter(filterName = "AdminLoginFilter")
public class AdminLoginFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {

        HttpSession session = ((HttpServletRequest)req).getSession();
        User user = (User)session.getAttribute("loginUser");
        if (user == null) {
            ((HttpServletResponse) resp).sendRedirect(((HttpServletRequest) req).getContextPath()+"/loginInput.jsp");
            return;
        }
        chain.doFilter(req, resp);
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
