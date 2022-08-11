import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/form_servlet.do")
public class Servlet01 extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int h = Integer.parseInt(req.getParameter("h"));
        int l = Integer.parseInt(req.getParameter("l"));
        StringBuilder sbd=new StringBuilder();
        sbd.append("<html lang='en'><head><meta charset='UTF-8'><title>Title</title><style>");
        sbd.append("table{border: 1px solid green;width: 50%;margin: 0px auto;}");
        sbd.append("table td{border: 1px solid blue;}</style></head><body><table>");
        for (int i = 1; i <=h ; i++) {
            sbd.append("<tr>");
            for (int j = 1; j <=l ; j++) {
                sbd.append("<td>");
                sbd.append(String.valueOf(i));
                sbd.append(String.valueOf(j));
                sbd.append("</td>");
            }
            sbd.append("</tr>");
        }
        sbd.append("</table></body></html>");

        // 设置响应内容和编码
        resp.setContentType("text/html;charset=utf-8");
        resp.setCharacterEncoding("utf-8");
        //响应内容给浏览器
        resp.getWriter().print(sbd.toString());
        resp.getWriter().write(sbd.toString());

    }
}
