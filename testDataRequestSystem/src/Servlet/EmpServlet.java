package Servlet;

import Dao.EmpDao;
import Dao.Impl.DaoEmpImpl;
import Pojo.Emp;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = "/EmpServlet.do")
public class EmpServlet extends HttpServlet {
    EmpDao empDao = new DaoEmpImpl();
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String lo = req.getParameter("lo");
        String hi = req.getParameter("hi");
//        System.out.println("S- "+lo+" -- "+hi);
//        System.out.println("+---+");
        List<Emp> list = null;
        try {
            list = empDao.find(lo,hi);
        }catch (Exception e){
            e.printStackTrace();
        }
//        System.out.println("tag01");
        req.setAttribute("list",list);
//        System.out.println(list.toString());
        //resp.sendRedirect("Entrance.jsp");
        req.getRequestDispatcher("/Entrance.jsp").forward(req,resp);
    }
}
