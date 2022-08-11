package com.sanyotan.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;

public class MyServlet extends HttpServlet{
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //随机生成语句
        int num = (int) (Math.random()*10) %2;
        String s = new Random().nextInt() ==0 ?"hello world@!":"You are a pig!!!";
        //响应
        PrintWriter writer = resp.getWriter();
        writer.write(s);
    }
}
