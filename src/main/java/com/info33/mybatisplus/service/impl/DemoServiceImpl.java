package com.info33.mybatisplus.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.info33.mybatisplus.dao.DemoDao;
import com.info33.mybatisplus.entity.Demo;
import com.info33.mybatisplus.service.DemoService;
import org.springframework.stereotype.Service;

@Service("DemoService")
public class DemoServiceImpl extends ServiceImpl<DemoDao, Demo> implements DemoService {
}
