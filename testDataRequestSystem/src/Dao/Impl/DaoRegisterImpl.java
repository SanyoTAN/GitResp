package Dao.Impl;

import Dao.Impl.ConnectionPool.MyConnectionPool;
import Dao.RegisterDao;
import Pojo.Register;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DaoRegisterImpl implements RegisterDao {


    @Override
    public Integer checkAccount(Register register) {
        Connection connection = null;
        PreparedStatement prepa = null;
        ResultSet resultSet = null;
        try {
            connection = MyConnectionPool.getConnection();
            prepa = connection.prepareStatement("select * from register where username=?");
            prepa.setString(1,register.getUsername());
            resultSet = prepa.executeQuery();
            System.out.println("Dao E : ---01---");
            //不存在数据情况
            if(resultSet==null) return 0;

            //存在数据情况
            resultSet.next();
            if(register.getPassword().equals(resultSet.getString("password"))){
                return 6;
            }else {
                return 1;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
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
        return 0;
    }

    @Override
    public boolean register(Register register) {
        Connection connection = null;
        PreparedStatement prepa = null;
        ResultSet resultSet = null;
        try {
            connection = MyConnectionPool.getConnection();
            prepa = connection.prepareStatement("select * from register where username=?");
            prepa.setString(1,register.getUsername());
            resultSet = prepa.executeQuery();
            System.out.println("CONNECTION ");
            int i=0;
/*            while (resultSet.next()){
                System.out.println("--" + i++);
                System.out.println(resultSet.getString("username"));
                System.out.println();
            }*/
            if(resultSet.next()){
                return false;
            }
            System.out.println("未注册");
            prepa = connection.prepareStatement("insert into register Values(?,?);");
            prepa.setString(1,register.getUsername());
            prepa.setString(2,register.getPassword());
            //prepa = connection.prepareStatement("commit; ");
            System.out.println("添加数据行数 : "+ prepa.executeUpdate());
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
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
        return false;
    }
}
