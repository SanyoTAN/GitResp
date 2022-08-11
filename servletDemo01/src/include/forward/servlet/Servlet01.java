package include.forward.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/servlet1.do")
public class Servlet01 extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("Servlet01 service invoked");
        System.out.println("money:"+req.getParameter("money"));//获得地址栏的参数

        resp.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");
        //请求转发另一个组件   请求转发的request和response不变
        //req.getRequestDispatcher("servlet2.do").forward(req,resp);
        req.getRequestDispatcher("servlet2.do").include(req,resp);
        //req.getRequestDispatcher("index.jsp");
        //请求转发可以转至WEB-INF的受保护的内容
        resp.getWriter().println("\nServlet1在转发之后增加的响应内容");

        /*
         * 1请求转发是一种服务器的行为,是对浏览器屏蔽
         * 2浏览器的地址栏不会发生变化
         * 3请求的参数是可以从源组件传递到目标组件的
         * 4请求对象和响应对象没有重新创建,而是传递给了目标组件
         * 5请求转发可以帮助我们完成页面的跳转
         * 6请求转发可以转发至WEB-INF里
         * 7请求转发只能转发给当前项目的内部资源,不能转发至外部资源
         * 8常用forward
         * */

        //响应重定向
        // 响应重定向
        //resp.sendRedirect("servlet4.do?money="+money);
        //resp.sendRedirect("WEB-INF/bbb.html");
        //resp.sendRedirect("https://www.baidu.com");
        /*
         * 响应重定向总结
         * 1重定向是服务器给浏览器重新指定请求方向 是一种浏览器行为 地址栏会发生变化
         * 2重定向时,请求对象和响应对象都会再次产生,请求中的参数是不会携带
         * 3重定向也可以帮助我们完成页面跳转
         * 4重定向不能帮助我们访问WEB-INF中的资源
         * 5重定向可以定向到外部资源
         *
         * */
    }
}
