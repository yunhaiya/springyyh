package com.jk.mapper;

import com.jk.model.QxModel;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface QxModelMapper {

    List<QxModel> queryQuanList();

    void deleteQuan(@Param("qid") String ids);

    QxModel queryQuanOne(@Param("q") String ids);

    void updateQuanOne(@Param("q")QxModel ids);

    void addQuanOne(@Param("q")QxModel ids);

    List<Integer> queryQuanByRid(@Param("rid")int rid);

    void deleteQuanByRid(@Param("rid")int rid);

    void saveQuanxian(@Param("rid")int rid, @Param("qxid")String[] split);
}