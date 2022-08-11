package Servlet;

import Dao.Impl.DaoRegisterImpl;
import Dao.RegisterDao;
import Pojo.Register;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/RegisterServlet.do")
public class RegisterServlet extends HttpServlet {
    RegisterDao registerDao = new DaoRegisterImpl();
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String url = null;
        //url = req.getRequestURI();//什么内容
        url= req.getHeader("Referer");
        if(url==null) System.out.println("url null");
        if(url.contains("login.jsp")) {
            switch (registerDao.checkAccount(new Register(req.getParameter("username"), req.getParameter("password")))){
                case 0:
                    req.getSession().setAttribute("statement","ANE");
                    req.getRequestDispatcher("login.jsp").forward(req,resp);
                    //resp.sendRedirect("login.jsp");
                case 1:
                    req.getSession().setAttribute("statement","PE");//不可以响应重定向到本身？
                    req.getRequestDispatcher("login.jsp").forward(req,resp);
                    //resp.sendRedirect("login.jsp");
                case 6:
                    System.out.println("去主页");
                    req.getSession().setAttribute("username",req.getParameter("username"));
                    resp.sendRedirect("Entrance.jsp");
            }
        }else {
            if(registerDao.register(new Register(req.getParameter("username"),req.getParameter("password")))){
                req.getSession().setAttribute("username",req.getParameter("username"));
                resp.sendRedirect("Entrance.jsp");
            }else{
                req.getSession().setAttribute("statement","AE");
                //resp.sendRedirect("register.jsp");
                resp.setContentType("text/javascript;charset=utf-8");
                resp.setCharacterEncoding("utf-8");
                resp.getWriter().print("alert('账号已经注册过，即将跳回登录页面')");
                try {
                    resp.wait(Long.parseLong("3000"));
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                 resp.sendRedirect("login.jsp");
               // req.getRequestDispatcher("login.jsp").forward(req,resp);
            }

        }


    }


}
