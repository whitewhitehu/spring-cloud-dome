package com.yangqifang.crm.api.dept.service;

import com.yangqifang.crm.api.dept.dto.DeptTree;
import com.yangqifang.crm.api.dept.entity.Dept;

import java.util.List;

/**
 * @author: yangqifang
 * @mall:yangqifang@baoku.com
 * @description: 2019/12/28 23:01
 */
public interface ICrmDeptService {
    List<DeptTree> getDeptTree(int deptID);

    List<DeptTree> DeptTreeGroup(List<DeptTree> deptTrees, int paranID);

    boolean update(Dept dept);

    boolean exist(Dept dept);

    boolean save(Dept dept);
}
