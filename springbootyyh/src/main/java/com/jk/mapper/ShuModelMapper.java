package com.jk.mapper;

import com.jk.model.ShuModel;
import com.jk.model.YhModel;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ShuModelMapper {

    List<ShuModel> queryTree(@Param("pid") int pid);


    List<ShuModel> queryTreeList2();

    void deleteTree(@Param("ids")String ids);
}
