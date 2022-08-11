import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/loginServlet.do")
public class loginServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        if(username.equals("sanyotan") && password.equals("123456")){
            User user = new User(null, null ,username, password);

            req.getSession().setAttribute("user",user);

            resp.sendRedirect(req.getContextPath()+"/mainServlet.do");
        }else {
            resp.addCookie(new Cookie("loginStatement","fail"));
            resp.sendRedirect(req.getContextPath()+"/login.html");
        }

    }
}
