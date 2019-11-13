package com.info33.mybatisplus.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.info33.mybatisplus.dao.ImgDao;
import com.info33.mybatisplus.entity.Img;
import com.info33.mybatisplus.service.ImgService;
import org.springframework.stereotype.Service;

@Service("ImgService")
public class ImgServiceImpl extends ServiceImpl<ImgDao, Img> implements ImgService {
}
