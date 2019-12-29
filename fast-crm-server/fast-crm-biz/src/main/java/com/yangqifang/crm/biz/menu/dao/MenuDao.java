package com.yangqifang.crm.biz.menu.dao;

import com.yangqifang.common.base.BaseInterface;
import com.yangqifang.crm.api.menu.entity.Menu;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface MenuDao extends BaseInterface<Menu> {
    @Override
    boolean save(@Param("menu") Menu menu);

    @Override
    boolean delect(@Param("menu") Menu menu);

    @Override
    boolean update(@Param(value = "menu") Menu menu);

    List<Menu> TreeMenu(@Param(value = "username") String username);

}
