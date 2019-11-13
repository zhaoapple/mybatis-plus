package com.info33.mybatisplus.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.info33.mybatisplus.dao.UserDao;
import com.info33.mybatisplus.entity.User;
import com.info33.mybatisplus.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

//<M extends BaseMapper<T>, T> T表示任意实体对象
@Service("UserService")
public class UserServiceImpl extends ServiceImpl<UserDao,User> implements UserService {

    @Autowired
    UserDao userDao;

    @Override
    public List<Map> getUser() {
        return userDao.selectAll();
    }
}
