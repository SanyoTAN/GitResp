<%--
  Created by IntelliJ IDEA.
  User: tians
  Date: 09/08/2022
  Time: 10:31 am
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="Content-Type"
          content="text/html; charset=utf-8">
    <title>账号注册</title>
</head>
<style>
  #a {
    width:50%;
    height:50%;
    border: 1px dashed ;
    background-color:lightgreen;
    text-align:center;
  }

  body{
    background-color:lightyellow;
  }

  span{
      text-align:center;
      color: brown;
      font-size: medium;
  }
</style>
<body>
    <%--注册框 --%>
    <div id="a">
      <h1>注册账号</h1>
      <form action="RegisterServlet.do"  method="get">
        账&nbsp;&nbsp;&nbsp;号:
        <input type="text"
               name="username">
        <br>

        密&nbsp;&nbsp;&nbsp;码:
        <input type="password"name="password">
        <br>

        姓名:
        <input type="text" name="name">
        <br>

        手机号:
        <input type="text" name="phonenumber">
        <br>
      <% if("AE".equals(request.getSession().getAttribute("statement"))){
          %>
          <span>账户名已经存在，请修改账户名并重新注册</span><br>
          <%
             request.getSession().removeAttribute("statement");
         }
      %>

        <input type="submit" value="注册">

        <input type="reset" value="重置">

      </form>
        <form method="get" action="login.jsp">
            <input type="submit" value="转至登陆界面">
        </form>
    </div>
</body>
</html>
