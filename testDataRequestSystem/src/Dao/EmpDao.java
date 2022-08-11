package Dao;

import Pojo.Emp;

import java.util.List;

public interface EmpDao {
    List<Emp> find(String lo,String hi);
}
