package com.yangqifang.crm.biz.sysdict.dao;

import com.yangqifang.common.base.BaseInterface;
import com.yangqifang.crm.api.sysdict.entity.SysDict;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author yangqifang
 */
@Mapper
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
