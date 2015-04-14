package shdev.oukongli.java;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by ou_kongli on 2015/4/14.
 */
public class ScopeServlet extends HttpServlet {

    //����2��init()������Ĭ��Ϊ���ô�������init()
    @Override
    public void init() throws ServletException {
        System.out.println("init servlet");
    }

    @Override
    public void init(ServletConfig config) throws ServletException {
        System.out.println(config.getInitParameter("username"));
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("service is invoking");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("do get");
    }

    @Override
    public void destroy() {
        System.out.println("destroy");
    }
}
