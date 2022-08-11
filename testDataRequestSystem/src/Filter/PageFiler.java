package Filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter(urlPatterns = "/*")
public class PageFiler implements Filter {

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req=(HttpServletRequest)servletRequest;
        HttpServletResponse resp=(HttpServletResponse) servletResponse;
        //无论是否登录过,都要放行的资源   登录页  登录校验Controller 和一些静态资源
        String requestURI = req.getRequestURI();
        System.out.println(requestURI);

       // filterChain.doFilter(req,resp);

        if(requestURI.contains("login.jsp")|| requestURI.contains("register.jsp")|| requestURI.contains(".do") ){
            // 直接放行
            System.out.println("放行");
            filterChain.doFilter(req,resp);
            // 后续代码不再执行
            return;
        }

        // 需要登录之后才能访问的资源,如果没登录,重定向到login.jsp上,提示用户进行登录
        HttpSession session = req.getSession();
        String username = (String) session.getAttribute("username");
        if(null != username){// 如果登录过 放行
            System.out.println("登陆过，放行");
            filterChain.doFilter(req,resp);
        }else{// 没有登录过,跳转至登录页
            System.out.println("没有放行");
            resp.sendRedirect("login.jsp");
        }
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void destroy() {

    }
}
