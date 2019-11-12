package com.jk.controller;

import com.jk.model.QxModel;
import com.jk.model.ShuModel;
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

        return service.queryQuanList();
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
    //去设置权限页面
    @RequestMapping("queryQuanXian")
    public String queryQuanXian(int rid ,Model model){
        model.addAttribute("rid", rid);
        return "quanxian/quanXian";
    }

    //回显设置权限
    @RequestMapping("queryQuanMenu")
    @ResponseBody
    public List<ShuModel> queryQuanMenu(int rid){
        return service.queryQuanMenu(-1,rid);
    }
    //回显设置权限
    @RequestMapping("saveQuanxian")
    @ResponseBody
    public String saveQuanxian(int rid ,String menuIds){
        service.saveQuanxian(rid,menuIds);
        return "suc";
    }




}
