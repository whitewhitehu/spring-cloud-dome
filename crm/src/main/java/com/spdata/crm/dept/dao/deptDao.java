package com.spdata.crm.dept.dao;

import com.spdata.common.base.BaseInterface;
import com.spdata.common.dept.Dept;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author yangqifang
 */
@Mapper
@Repository
public interface deptDao extends BaseInterface<Dept> {
    List<Dept> findDeptChild(Integer id);
}
