<%--
  Created by IntelliJ IDEA.
  User: tians
  Date: 09/08/2022
  Time: 10:29 am
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Welcome to login Page</title>
    <meta http-equiv="Content-Type"
          content="text/html; charset=ISO-utf-8">
    <title>登录</title>
    <style>
        #a {

            width:50%;
            height:200px;
            border: 1px dashed ;
            background-color:lightyellow;
            text-align:center;
        }
        body{
            background-color:lightblue;
        }
        span{
            text-align:center;
            color: brown;
            font-size: medium;
        }
    </style>
</head>
<body>
    <div id="a">
        <h1>登录界面</h1>
        <form action="RegisterServlet.do" method="get">
            账号:<input type="text" name="username"/>
            <br>
            密码:<input type="password"name="password"/>
            <br>
            <%
                if("ANE".equals(request.getSession().getAttribute("statement"))){
            %>
                <span>账户不存在，请重新输入</span>
                <br>
            <%  request.getSession().removeAttribute("statement");
                }else if("PE".equals(request.getSession().getAttribute("statement"))){
            %>
                <span>密码错误，请重新输入</span>
                <br>
            <%  request.getSession().removeAttribute("statement");
                }
            %>
            <input type="submit" value="login"/>
            没有账号？<a href ="register.jsp">注册账号</a>
        </form>
    </div>
</body>
</html>
