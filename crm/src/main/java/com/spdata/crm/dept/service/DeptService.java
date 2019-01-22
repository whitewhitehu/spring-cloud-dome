package com.spdata.crm.dept.service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.spdata.common.base.BaseService;
import com.spdata.common.dept.Dept;
import com.spdata.crm.account.dao.AccountDao;
import com.spdata.crm.dept.dao.deptDao;
import com.spdata.crm.dept.entity.DeptTree;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author yangqifang
 * @描述:
 * @data 2019/1/2216:03
 **/
@Log
@Service
public class DeptService extends BaseService<deptDao, Dept> {
    @Autowired
    private deptDao deptDao;
    @Autowired
    private AccountDao accountDao;

    /**
     * 获取当前部门与子部门树
     *
     * @param deptID
     * @return
     */
    public List<DeptTree> getDeptTree(int deptID) {
        List<Dept> deptall = deptDao.findDeptChild(deptID);
        List<DeptTree> deptTrees = new ArrayList<>();
        /**
         * 将Dept类转换为子类DeptTrees
         */
        deptall.forEach(dept -> {
            String json = JSONObject.toJSONString(dept);
            DeptTree tree = JSON.parseObject(json, DeptTree.class);
            deptTrees.add(tree);
        });
        //查找当前部门
        DeptTree parentDeptNode = deptTrees.stream().filter(node -> node.getId().equals(deptID)).findAny().get();
        List<DeptTree> treeList = DeptTreeGroup(deptTrees, deptID);
        /**
         * 如果当前部门存在就将部门子树添加子属性中
         */
        if (parentDeptNode != null) {
            List<DeptTree> deptTreesNodes = new ArrayList<>();
            parentDeptNode.setChildren(treeList);
            deptTreesNodes.add(parentDeptNode);
            return deptTreesNodes;
        }
        return treeList;
    }

    /**
     * 递归查找子部门树
     *
     * @param deptTrees
     * @param paranID
     * @return
     */
    private List<DeptTree> DeptTreeGroup(List<DeptTree> deptTrees, int paranID) {
        //子节点
        List<DeptTree> children = deptTrees.stream().filter(item -> item.getParent() == paranID).collect(Collectors.toList());
        //非子结点
        List<DeptTree> successor = deptTrees.stream().filter(item -> item.getParent() != paranID).collect(Collectors.toList());
        children.forEach(item -> {
            List<DeptTree> list = DeptTreeGroup(successor, item.getId());
            for (DeptTree tree : list) {
                item.getChildren().add(tree);
            }
        });
        return children;
    }

    @Transactional(rollbackFor = Exception.class)
    public boolean update(Dept dept) {
        return deptDao.update(dept);
    }
}
