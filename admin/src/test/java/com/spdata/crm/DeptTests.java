package com.spdata.crm;

import com.spdata.common.dept.Dept;
import com.spdata.crm.dept.dao.deptDao;
import com.spdata.crm.dept.entity.DeptTree;
import com.spdata.crm.dept.service.DeptService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * @author yangqifang
 * @描述:
 * @data 2019/1/2122:10
 **/
@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
public class DeptTests {
    @Autowired
    private deptDao deptDao;
    @Autowired
    private DeptService deptService;

    @Test
    public void getDeptTree() {
        List<DeptTree> treeList = deptService.getDeptTree(3);
        log.warn(treeList.toString());
    }

    @Test
    public void deptInsert() {
        Dept dept = new Dept();
        dept.setName("测试顶级部门");
        dept.setParent(0);
        deptDao.save(dept);
    }

    @Test
    public void updateDept() {
        Dept dept = new Dept();
        dept.setId(10);
        dept.setName("dept-update");
        dept.setParent(1);
        deptDao.update(dept);
    }
}
