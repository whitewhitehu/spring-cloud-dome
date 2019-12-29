package com.yangqifang.crm.api.propertie.service;

import com.github.pagehelper.PageInfo;
import com.yangqifang.common.base.PageParameter;
import com.yangqifang.crm.api.propertie.entity.Properties;

/**
 * @author: yangqifang
 * @mall:yangqifang@baoku.com
 * @description: 2019/12/29 1:30
 */
public interface ICrmPropertiesService {
    boolean save(Properties entity);

    boolean delect(Properties properties);

    boolean update(Properties properties);

    PageInfo<Properties> findByPage(PageParameter<Properties> parameter);
}
