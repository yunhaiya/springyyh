package com.jk.service;

import com.jk.model.QxModel;
import com.jk.model.ShuModel;

import java.util.List;

public interface QuanService {
    List<QxModel> queryQuanList();

    void deleteQuan(String ids);

    QxModel queryQuanOne(String ids);

    void updateQuanOne(QxModel ids);

    void addQuanOne(QxModel ids);

    List<ShuModel> queryQuanMenu(int i, int rid);

    void saveQuanxian(int rid, String menuIds);
}
