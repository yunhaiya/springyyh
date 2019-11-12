package com.jk.service;

import com.jk.model.QxModel;
import org.springframework.stereotype.Service;

import java.util.List;
@Service("quanService")
public interface QuanService {
    List<QxModel> queryQuanList();

    void deleteQuan(String ids);

    QxModel queryQuanOne(String ids);

    void updateQuanOne(QxModel ids);

    void addQuanOne(QxModel ids);
}
