<%@ page import="Pojo.Emp" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: tians
  Date: 08/08/2022
  Time: 4:20 pm
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>S DataRequestSystem</title>
    <script type="text/javascript" src="jquery.min.js"></script>
    <style>
        table{
            border: 3px solid blue;
            width: 80%;
            margin: 0px auto;
        }
        td,th{
            border: 2px solid green;
        }
        form{
            border: 3px solid rosybrown;
            width: 80%;
            margin: 0px auto;
        }
        #topp{
            width: 100%;
            height: 36px;
            background-color: aqua;
            font-size: 22px;
            color: brown;
            text-align: center;
        }

    </style>
</head>
<body>
    <div id="topp">
        欢迎  ${username}  访问 ！
    </div>
    <br>
    <form method="get" action="EmpServlet.do">
        请输入员工编号范围
        <%  String lo = request.getParameter("lo");
        String hi = request.getParameter("hi");
//            System.out.println(lo+"  --  "+hi);
        if(lo!="" && lo!=null){
    %><input style="color: darkcyan" type="text" name="lo" value=<%=lo%> > 到 <input style="color: darkcyan" type="text" name="hi" value=<%=hi%>>
        <%} else {
        %><input type="text" name="lo"> 到 <input type="text" name="hi">
        <%}%>
        <input type="submit" style="text-align: center;" >
    </form>
    <!--实现点击的时候提交request请求,应该是后来请求回来才响应-->


<table cellspacing="0px" cellpadding="0px">
    <tr>
        <th>编号</th>
        <th>姓名</th>
        <th>上级编号</th>
        <th>职务</th>
        <th>入职日期</th>
        <th>薪资</th>
        <th>补助</th>
        <th>部门号</th>
        <th>薪资等级</th>
    </tr>
    <%
        List<Emp> emps = (List<Emp>) request.getAttribute("list");
//        System.out.println(emps);
        if(emps!=null)
        for (Emp emp : emps) {
    %>
    <tr>
        <td><%=emp.getEmpno()%></td>
        <td><%=emp.getEname()%></td>
        <td><%=emp.getMgr()%></td>
        <td><%=emp.getJob()%></td>
        <td><%=emp.getHiredate()%></td>
        <td><%=emp.getSal()%></td>
        <td><%=emp.getComm()%></td>
        <td><%=emp.getDeptno()%></td>
        <td><%--out.print("<td>")--%>
            <%
                Double sal = emp.getSal();
                if(sal<=500){
                    out.print("A");
                }else if( sal <=1000){
                    out.print("B");
                }else if( sal <=1500){
                    out.print("C");
                }else if( sal <=2000){
                    out.print("D");
                }else if( sal <=3000){
                    out.print("E");
                }else if( sal <=4000){
                    out.print("F");
                }else {
                    out.print("G");
                }
            %>
        </td>
    </tr>
    <%
        }

    %>
</table>

</body>
</html>
