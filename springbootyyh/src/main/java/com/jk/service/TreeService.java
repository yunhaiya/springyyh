package com.jk.service;

import com.jk.model.ShuModel;
import com.jk.model.YhModel;

import java.util.List;

public interface TreeService {
    List<ShuModel> queryTreeList(int pid);

    List<YhModel> queryYh();

    List<ShuModel> queryTreeList2();

    void deleteTree(String ids);
}
