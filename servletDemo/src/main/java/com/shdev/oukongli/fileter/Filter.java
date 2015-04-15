package com.shdev.oukongli.fileter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

/**
 * Created by ou_kongli on 2015/4/15.
 */
@WebFilter(filterName = "Filter")
public class Filter implements javax.servlet.Filter {
    private String encoding;

    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        System.out.println("filter start");
        req.setCharacterEncoding(encoding);
        chain.doFilter(req, resp);
        System.out.println("filter finish");
    }

    public void init(FilterConfig config) throws ServletException {
        String e = config.getInitParameter("encoding");
        if (e == null || "".equals(e.trim())) {
            encoding = "UTF-8";
        } else {
            encoding = e;
        }
    }

}
