package com.yangqifang.crm.biz.propertie.dao;

import com.yangqifang.common.base.BaseDaoInterface;
import com.yangqifang.crm.api.propertie.entity.Properties;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author yangqifang
 */
@Mapper
public interface PropertiesDao extends BaseDaoInterface<Properties> {
    @Override
    boolean save(Properties properties);

    @Override
    List<Properties> findByPage(Properties properties);

    @Override
    boolean update(Properties properties);

    @Override
    boolean delect(Properties properties);
}
