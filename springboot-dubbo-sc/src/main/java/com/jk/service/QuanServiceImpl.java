package com.jk.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.jk.mapper.QxModelMapper;
import com.jk.mapper.XsModelMapper;
import com.jk.model.QxModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component
@Service(version = "1.0",interfaceClass = QuanService.class)
public class QuanServiceImpl implements  QuanService{
    @Autowired
    private QxModelMapper qxdao;
    @Autowired
    private XsModelMapper xsdao;

    @Override
    public List<QxModel> queryQuanList() {
        return qxdao.queryQuanList();
    }

    @Override
    public void deleteQuan(String ids) {
        qxdao.deleteQuan(ids);
    }

    @Override
    public QxModel queryQuanOne(String ids) {
        return qxdao.queryQuanOne(ids);
    }

    @Override
    public void updateQuanOne(QxModel ids) {
        qxdao.updateQuanOne(ids);
    }

    @Override
    public void addQuanOne(QxModel ids) {
        qxdao.addQuanOne(ids);
    }

    @Override
    public void addQuanAll(QxModel list) {
        qxdao.addQuanAll(list);
    }

    @Override
    public List<Map<String, Object>> queryShowBing() {
        return qxdao.queryShowBing();
    }

    @Override
    public List<Map<String, Object>> queryZhou() {
        return qxdao.queryZhou();
    }

    @Override
    public List<Map<String, Object>> queryZhu() {
        return qxdao.queryZhu();
    }

}
