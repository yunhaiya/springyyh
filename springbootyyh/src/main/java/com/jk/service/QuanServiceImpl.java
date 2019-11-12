package com.jk.service;

import com.jk.mapper.QxModelMapper;
import com.jk.mapper.ShuModelMapper;
import com.jk.model.QxModel;
import com.jk.model.ShuModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuanServiceImpl implements  QuanService{
    @Autowired
    private QxModelMapper qxdao;
    @Autowired
    private ShuModelMapper shumapper;

    @Override
    public List<QxModel> queryQuanList() {
        return qxdao.queryQuanList();
    }

    @Override
    public void deleteQuan(String ids) {
        qxdao.deleteQuan(ids);
    }

    @Override
    public QxModel queryQuanOne(String ids) {
        return qxdao.queryQuanOne(ids);
    }

    @Override
    public void updateQuanOne(QxModel ids) {
        qxdao.updateQuanOne(ids);
    }

    @Override
    public void addQuanOne(QxModel ids) {
        qxdao.addQuanOne(ids);
    }

    @Override
    public List<ShuModel> queryQuanMenu(int pid, int rid) {
//		1.根据pid 查询所有子节点列表
        List<ShuModel> menus1 = shumapper.queryTree(pid);
//		查询该角色已有的所有权限id集合----------查询角色权限中间表
        List<Integer> roleMenus = qxdao.queryQuanByRid(rid);
//		2.判断该列表不为空 有值
        if(menus1 != null && menus1.size() >0){
//			3.循环该列表
            for (int i = 0; i < menus1.size(); i++) {
//				4.在循环体内 将当前元素的id 作为pid 调用当前方法本身 进行递归
                List<ShuModel> menus2 = queryQuanMenu(menus1.get(i).getId(),rid);
//				5.如果能够查到子节点列表 则将该列表放到 children属性中
                menus1.get(i).setChildren(menus2);

                for (int j = 0; j < roleMenus.size(); j++) {
//					如果根据当前节点id 没有查到子节点列表 说明当前节点对象是最底层的节点
//					并且 如果该节点id 与 角色已拥有的权限id相同 则设置该节点对象的checked=true
                    if(menus2.size() <=0 && menus1.get(i).getId() == roleMenus.get(j)){
//						当角色已拥有的权限id 在 权限集合中被找到 则设置业务字段——————checked
                        menus1.get(i).setChecked(true);
                    }

                }
            }
        }

        return menus1;
    }

    @Override
    public void saveQuanxian(int rid, String menuIds) {
        //		1.删除中间表数据
        qxdao.deleteQuanByRid(rid);
//		2.重新添加中间表
        qxdao.saveQuanxian(rid,menuIds.split(","));
    }
}
