package com.spdata.crm.serverconfig.service;

import com.spdata.common.base.BaseService;
import com.spdata.common.config.Properties;
import com.spdata.crm.serverconfig.dao.PropertiesDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author yangqifang
 * @描述: 服务配置业务层
 * @data 2019/3/720:55
 **/
@Service
public class PropertiesService extends BaseService<PropertiesDao, Properties> {
    private Logger logger = LoggerFactory.getLogger(PropertiesService.class);
    @Autowired
    private PropertiesDao propertiesDao;

    @Transactional(rollbackFor = Exception.class)
    @Override
    public boolean save(Properties entity) {
        return super.save(entity);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public boolean delect(Properties properties) {
        return super.delect(properties);
    }

    @Transactional(rollbackFor = Exception.class)
    public boolean update(Properties properties) {
        return propertiesDao.update(properties);
    }

}
