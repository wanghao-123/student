package com.cssl.service.Impl;

import com.cssl.dao.UsersDao;
import com.cssl.pojo.Users;
import com.cssl.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
@Transactional
public class UsersServiceImpl implements UsersService {
    @Autowired
    private UsersDao usersDao;
    @Override
    public List<Users> selectAll(Users users) {
        return usersDao.selectAll(users);
    }

    @Override
    public int insertUser(Users users) {
        return usersDao.insertUser(users);
    }

    @Override
    public int selectName(Users users) {
        return usersDao.selectName(users);
    }
}
