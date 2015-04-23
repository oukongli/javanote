package com.shdev.oukongli.filter;

import com.shdev.oukongli.model.SystemContext;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

/**
 * Created by ou_kongli on 2015/4/22.
 */
@WebFilter(filterName = "SystemContextFilter")
public class SystemContextFilter implements Filter {
    int pageSize;
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        try {
            int pageIndex = 1;
            int pageOffSet = 0;
            try {
//                pageIndex = Integer.parseInt(req.getParameter("pageIndex"));
                pageOffSet = Integer.parseInt(req.getParameter("pager.offset"));
            } catch (NumberFormatException e) {
            }
            SystemContext.setPageIndex(pageIndex);
            SystemContext.setPageSize(pageSize);
            SystemContext.setPageOffSet(pageOffSet);
            chain.doFilter(req, resp);
        } finally {
            SystemContext.removePageIndex();
            SystemContext.removePageSize();
            SystemContext.removePageOffset();
        }
    }

    public void init(FilterConfig config) throws ServletException {
        try {
            pageSize = Integer.parseInt(config.getInitParameter("pageSize"));
        } catch (NumberFormatException e) {
            pageSize = 15;
        }
    }

}
