import model.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by ou_kongli on 2015/5/14.
 */
public class HelloServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("hello", "this is server forward by RequestDispatcher");
        req.setAttribute("user", new User("oukongli","欧孔礼",25));
        ArrayList<User> users = new ArrayList<User>();
        users.add(new User("oukongli","欧孔礼",25));
        users.add(new User("1","1",1));
        users.add(new User("2","2",2));
        req.setAttribute("users", users);
        RequestDispatcher dispatcher = req.getRequestDispatcher("01/02.jsp");
        dispatcher.forward(req, resp);
    }
}
