package com.spdata.crm.serverconfig.dao;

import com.spdata.common.base.BaseInterface;
import com.spdata.common.config.Properties;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author yangqifang
 */
@Mapper
public interface PropertiesDao extends BaseInterface<Properties> {
    @Override
    boolean save(Properties properties);

    @Override
    List<Properties> findByPage(Properties properties);

    @Override
    boolean update(Properties properties);

    @Override
    boolean delect(Properties properties);
}
