package com.yangqifang.crm.biz.dept.dao;

import com.yangqifang.common.base.BaseDaoInterface;
import com.yangqifang.crm.api.dept.entity.Dept;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author yangqifang
 */
@Mapper
public interface deptDao extends BaseDaoInterface<Dept> {
    List<Dept> findDeptChild(Integer id);

    Dept findByName(Dept dept);
}
