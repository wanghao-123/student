package com.cssl.service;

import com.cssl.pojo.Users;

import java.util.List;

public interface UsersService {
    public List<Users> selectAll(Users users);
    public int insertUser(Users users);
    public int selectName(Users users);
}
