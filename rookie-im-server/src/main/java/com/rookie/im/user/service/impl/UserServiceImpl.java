package com.rookie.im.user.service.impl;

import com.rookie.im.user.dao.UserDao;
import com.rookie.im.user.domain.entity.User;
import com.rookie.im.user.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements IUserService {
    @Autowired
    private UserDao userDao;

    @Override
    public User getUserById(Integer id) {
        return userDao.lambdaQuery().eq(User::getId, id).one();
    }
}
