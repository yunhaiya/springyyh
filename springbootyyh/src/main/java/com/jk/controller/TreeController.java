package com.jk.controller;

import com.jk.model.ShuModel;
import com.jk.service.TreeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class TreeController {
    @Autowired
    private TreeService treeservice;

    @RequestMapping("toShow")
    public String toShow() {
        return "show";
    }

    @RequestMapping("toqueryTree")
    public String toqueryYh(){

        return  "tree/queryTree";
    }
    @RequestMapping("queryTree")
        @ResponseBody
        public List<ShuModel> queryTreeList() {
            int pid = -1;
            List<ShuModel> list = treeservice.queryTreeList(pid);
            return list;
    }

    @RequestMapping("queryTreeList2")
    @ResponseBody
    public List<ShuModel> queryTreeList2() {
        List<ShuModel> list = treeservice.queryTreeList2();
        return list;
    }



    //删除树
    @RequestMapping("deleteTree")
    @ResponseBody
    public String deleteTree(String ids){
        treeservice.deleteTree(ids);
        return "s";
    }
}
