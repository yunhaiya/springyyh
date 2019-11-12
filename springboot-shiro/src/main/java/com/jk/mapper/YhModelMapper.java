package com.jk.mapper;

import com.jk.model.YhModel;
import org.apache.ibatis.annotations.Param;

public interface YhModelMapper {

    YhModel queryUserByName(@Param(("usname")) String username);
}