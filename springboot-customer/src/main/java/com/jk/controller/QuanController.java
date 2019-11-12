package com.jk.controller;

import com.jk.model.QxModel;
import com.jk.service.QuanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class QuanController {
    @Autowired
    private QuanService service;

    @RequestMapping("toqueryQuan")
    public String toqueryQuan() {
        return "quanxian/queryQuan";
    }

    @RequestMapping("queryQuan")
    @ResponseBody
    public List<QxModel> queryQuan() {
        List<QxModel> quan=service.queryQuanList();
        System.out.println("111");
        return quan;
    }
    //删除权限
    @RequestMapping("deleteQuan")
    @ResponseBody
    public String deleteQuan(String ids){
        service.deleteQuan(ids);
        return "s";
    }

    @RequestMapping("toqueryQuanOne")
    public String toqueryQuanOne(Model model,String ids){
        QxModel qx=service.queryQuanOne(ids);
        model.addAttribute("a",qx);


        return "/quanxian/updatequan";
    }

    @RequestMapping("updateQuanOne")
    @ResponseBody
    public String updateQuanOne(QxModel ids){
        service.updateQuanOne(ids);

        return "a";
    }

    @RequestMapping("toadd")
    public String toadd() {
        return "quanxian/addQuan";
    }

    @RequestMapping("addQuanOne")
    @ResponseBody
    public String addQuanOne(QxModel ids){
        service.addQuanOne(ids);
        return "a";
    }




}
