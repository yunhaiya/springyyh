package com.jk.service;

import com.jk.mapper.ShuModelMapper;
import com.jk.mapper.YhModelMapper;
import com.jk.model.ShuModel;
import com.jk.model.YhModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sun.reflect.generics.tree.Tree;

import java.util.List;

@Service
public class TreeServiceImpl implements  TreeService{
    @Autowired
    private ShuModelMapper shumapper;
    @Autowired
    private YhModelMapper yhmapper;



    @Override
    public List<ShuModel> queryTreeList(int pid) {
//		根据pid查询子节点 第一次 根据-1 查询顶级节点集合
        List<ShuModel> menus = shumapper.queryTree(pid);
        if(menus != null && menus.size()>0){
//			循环集合，
            for (int i = 0; i < menus.size(); i++) {
//				根据当前节点id查询子节点列表
                List<ShuModel> menus2 = queryTreeList(menus.get(i).getId());
//				则将子节点列表set到当前节点对象的children属性中
                menus.get(i).setChildren(menus2);
            }
        }
        return menus;
    }

    @Override
    public List<YhModel> queryYh() {
        return yhmapper.queryYh();
    }

    @Override
    public List<ShuModel> queryTreeList2() {
        return shumapper.queryTreeList2();
    }

    @Override
    public void deleteTree(String ids) {
        shumapper.deleteTree(ids);
    }


}
