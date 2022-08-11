package include.forward.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/servlet2.do")
public class Servlet02 extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("Servlet01 service invoked");

        String money = req.getParameter("money");
        System.out.println("money:"+money);//获得地址栏的参数

        //做出响应
        resp.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");

        resp.getWriter().println("支付宝到账："+money+"元");
    }
}
