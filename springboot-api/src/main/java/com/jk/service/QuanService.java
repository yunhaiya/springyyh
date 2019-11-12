package com.jk.service;

import com.jk.model.QxModel;

import java.util.List;
import java.util.Map;

public interface QuanService {
    List<QxModel> queryQuanList();

    void deleteQuan(String ids);

    QxModel queryQuanOne(String ids);

    void updateQuanOne(QxModel ids);

    void addQuanOne(QxModel ids);

    void addQuanAll(QxModel list);

    List<Map<String, Object>> queryShowBing();

    List<Map<String, Object>> queryZhou();

    List<Map<String, Object>> queryZhu();
}
