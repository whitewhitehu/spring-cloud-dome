package com.yangqifang.crm.biz.propertie.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.PageInfo;
import com.yangqifang.common.base.PageParameter;
import com.yangqifang.crm.api.propertie.entity.Properties;
import com.yangqifang.crm.api.propertie.service.ICrmPropertiesService;
import com.yangqifang.crm.biz.propertie.service.PropertiesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author: yangqifang
 * @mall:yangqifang@baoku.com
 * @description: 2019/12/29 1:32
 */
@Service
@Component
public class CrmPropertiesService implements ICrmPropertiesService {
    @Autowired
    private PropertiesService propertiesService;

    @Override
    public boolean save(Properties entity) {
        return propertiesService.save(entity);
    }

    @Override
    public boolean delect(Properties properties) {
        return propertiesService.delect(properties);
    }

    @Override
    public boolean update(Properties properties) {
        return propertiesService.update(properties);
    }

    @Override
    public PageInfo<Properties> findByPage(PageParameter<Properties> parameter) {
        return propertiesService.findByPage(parameter);
    }
}
