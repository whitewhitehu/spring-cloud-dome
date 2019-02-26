package com.spdata.crm.sysdict.dao;

import com.spdata.common.base.BaseInterface;
import com.spdata.common.sysdict.SysDict;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author yangqifang
 */
@Mapper
@Repository
public interface SysDictDao extends BaseInterface<SysDict> {

    @Override
    boolean update(@Param(value = "sysDict") SysDict sysDict);

    @Override
    List<SysDict> findByPage(SysDict sysDict);

    @Override
    boolean save(@Param(value = "sysDict") SysDict sysDict);

    @Override
    boolean delect(SysDict sysDict);
}
