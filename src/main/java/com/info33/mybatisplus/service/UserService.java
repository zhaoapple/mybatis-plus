package com.info33.mybatisplus.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.info33.mybatisplus.entity.User;

import java.util.List;
import java.util.Map;

public interface UserService extends IService<User> {

    List<Map> getUser();
}
