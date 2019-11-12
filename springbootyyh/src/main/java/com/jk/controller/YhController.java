package com.jk.controller;

import com.jk.model.YhModel;
import com.jk.service.TreeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class YhController {

    @Autowired
    private TreeService service;


    @RequestMapping("toqueryYh")
    public String toqueryYh(){

        return  "user/showYh";
    }


    @RequestMapping("queryYh")
    @ResponseBody
    public List<YhModel> queryYh(){

        return  service.queryYh();
    }

}
