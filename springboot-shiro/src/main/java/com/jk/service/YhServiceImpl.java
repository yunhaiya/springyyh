package com.jk.service;

import com.jk.mapper.YhModelMapper;
import com.jk.model.YhModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class YhServiceImpl implements  YhService{

    @Autowired
    private YhModelMapper yhdao;
    @Override
    public YhModel queryUserByName(String username) {
        return yhdao.queryUserByName(username);
    }
}
