package com.info33.mybatisplus.controller;

import com.info33.mybatisplus.entity.Img;
import com.info33.mybatisplus.service.ImgService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("page")
public class PageController {

    @Autowired
    ImgService imgService;

    @GetMapping("hello")
    @ResponseBody
    public List hello(){
        List<Img> list = imgService.list();
        List returnImgInfos = new ArrayList();
//        for (Img img : list) {
//            returnImgInfos.add(img.getImgUrl());
//        }
        File file = new File("E:/9-9/page");
        File[] filesArr = file.listFiles();
        for(File f: filesArr){
            returnImgInfos.add(f.getName());
        }
        return returnImgInfos;
    }
}
