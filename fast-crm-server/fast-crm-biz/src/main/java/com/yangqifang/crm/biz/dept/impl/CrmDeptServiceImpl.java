package com.yangqifang.crm.biz.dept.impl;

import org.apache.dubbo.config.annotation.Service;
import com.yangqifang.crm.api.dept.dto.DeptTree;
import com.yangqifang.crm.api.dept.entity.Dept;
import com.yangqifang.crm.api.dept.service.ICrmDeptService;
import com.yangqifang.crm.biz.dept.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author: yangqifang
 * @mall:yangqifang@baoku.com
 * @description: 2019/12/28 23:06
 */
@Service
@Component
public class CrmDeptServiceImpl implements ICrmDeptService {
    @Autowired
    private DeptService deptService;

    @Override
    public List<DeptTree> getDeptTree(int deptID) {
        return deptService.getDeptTree(deptID);
    }

    @Override
    public List<DeptTree> DeptTreeGroup(List<DeptTree> deptTrees, int paranID) {
        return deptService.DeptTreeGroup(deptTrees, paranID);
    }

    @Override
    public boolean update(Dept dept) {
        return deptService.update(dept);
    }

    @Override
    public boolean exist(Dept dept) {
        return deptService.exist(dept);
    }

    @Override
    public boolean save(Dept dept) {
        return deptService.save(dept);
    }
}
