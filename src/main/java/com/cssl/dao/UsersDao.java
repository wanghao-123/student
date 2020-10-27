package com.cssl.dao;

import com.cssl.pojo.Users;

import java.util.List;

public interface UsersDao {
    public List<Users> selectAll(Users users);
    public int insertUser(Users users);
    public int selectName(Users users);
}
