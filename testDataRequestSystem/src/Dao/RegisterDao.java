package Dao;

import Pojo.Register;

public interface RegisterDao {
    Integer checkAccount(Register register);
    boolean register(Register register);
}
