package com.jk.mapper;

import com.jk.model.QxModel;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface QxModelMapper {

    List<QxModel> queryQuanList();

    void deleteQuan(@Param("qid") String ids);

    QxModel queryQuanOne(@Param("q") String ids);

    void updateQuanOne(@Param("q") QxModel ids);

    void addQuanOne(@Param("q") QxModel ids);

    void deleteQuanByRid(@Param("rid") int rid);

    void addQuanAll(@Param("list")QxModel list);

    List<Map<String, Object>> queryShowBing();

    List<Map<String, Object>> queryZhou();

    List<Map<String, Object>> queryZhu();
}