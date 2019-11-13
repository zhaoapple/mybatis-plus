package com.info33.mybatisplus.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.info33.mybatisplus.entity.User;

import java.util.List;
import java.util.Map;

public interface UserDao extends BaseMapper<User> {

    List<Map> selectAll();
}
