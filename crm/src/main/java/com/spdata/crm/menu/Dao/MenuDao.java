package com.spdata.crm.menu.Dao;

import com.spdata.entity.Base.BaseInterface;
import com.spdata.entity.Menu.Menu;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component
public interface MenuDao extends BaseInterface<Menu> {
    @Override
    boolean save(@Param("menu") Menu menu);

    @Override
    boolean delect(@Param("menu") Menu menu);

    boolean update(@Param(value = "menu") Menu menu);

    List<Menu> TreeMenu(@Param(value = "username") String username);

    List<Menu> TreeChildren(@Param(value = "id") Integer id, @Param(value = "username") String username);

}
