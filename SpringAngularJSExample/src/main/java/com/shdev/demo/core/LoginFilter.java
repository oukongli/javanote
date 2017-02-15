package com.shdev.demo.core;

import com.shdev.demo.common.Constants;
import com.shdev.demo.common.Universe;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by ou_ko on 2017/2/15.
 */
public class LoginFilter implements Filter {
    private static final Logger logger = Logger.getLogger(LoginFilter.class);

    private static String loginUrl;

    public void init(FilterConfig filterConfig) throws ServletException {
        loginUrl = filterConfig.getInitParameter("loginUrl");
    }

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        HttpSession httpSession = httpServletRequest.getSession();
        Object object = httpSession.getAttribute(Constants.SUBJECT);
        String requestUrl = httpServletRequest.getRequestURI();
        if (requestUrl == null) {
            requestUrl = loginUrl;
        }
        if (!requestUrl.contains(loginUrl)) {
            if (object == null) {
                ((HttpServletResponse) response).sendRedirect("/login?url=" + requestUrl);
                return;
            }
        }
        chain.doFilter(request, response);
        Universe.clear();
    }

    public void destroy() {

    }
}
