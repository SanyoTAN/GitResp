package Dao.Impl;

import Dao.EmpDao;
import Dao.Impl.ConnectionPool.MyConnectionPool;
import Pojo.Emp;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DaoEmpImpl implements EmpDao {
    @Override
    public List<Emp> find(String lo,String hi) {
        List<Emp> list = new ArrayList<>();
        Connection connection = null;
        PreparedStatement prepa = null;
        ResultSet resultSet = null;
        try{
            connection = MyConnectionPool.getConnection();
            prepa = connection.prepareStatement("select * from emp where empno>=? and empno<=?");
            prepa.setString(1,lo);
            prepa.setString(2,hi);
            resultSet = prepa.executeQuery();
            while (resultSet.next()){
                Integer empno=resultSet.getInt("empno");
//                System.out.println("Inside Operation "+empno);
                Integer deptno=resultSet.getInt("deptno");
                Integer mgr=resultSet.getInt("mgr");
                String ename=resultSet.getString("ename");
                String job=resultSet.getString("job");
                Double sal=resultSet.getDouble("sal");
                Double comm=resultSet.getDouble("comm");
                Date hiredate=resultSet.getDate("hiredate");
                Emp emp =new Emp( empno,  ename,  job,  mgr,  hiredate,  sal,  comm,  deptno);
                list.add(emp);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if(null!=resultSet){
                try {
                    resultSet.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if(null!=prepa){
                try {
                    prepa.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if(null!=connection){
                MyConnectionPool.returnConnection(connection);
            }
        }
//        System.out.print("Inside operation ");
//        for (Emp emp : list) {
//            System.out.println(emp.getJob());
//        }
        return list;
    }
}
