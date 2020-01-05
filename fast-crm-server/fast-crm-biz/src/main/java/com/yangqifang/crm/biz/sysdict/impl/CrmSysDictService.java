package com.yangqifang.crm.biz.sysdict.impl;

import org.apache.dubbo.config.annotation.Service;
import com.github.pagehelper.PageInfo;
import com.yangqifang.common.base.PageParameter;
import com.yangqifang.crm.api.sysdict.entity.SysDict;
import com.yangqifang.crm.api.sysdict.service.ICrmSysDictService;
import com.yangqifang.crm.biz.sysdict.service.SysDictService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author: yangqifang
 * @mall:yangqifang@baoku.com
 * @description: 2019/12/29 1:41
 */
@Service
@Component
public class CrmSysDictService implements ICrmSysDictService {
    @Autowired
    private SysDictService sysDictService;

    @Override
    public SysDict insert(SysDict sysDict) {
        return sysDictService.insert(sysDict);
    }

    @Override
    public boolean update(SysDict sysDict) {
        return sysDictService.update(sysDict);
    }

    @Override
    public boolean delect(SysDict sysDict) {
        return sysDictService.delect(sysDict);
    }

    @Override
    public boolean save(SysDict sysDict) {
        return sysDictService.save(sysDict);
    }

    @Override
    public PageInfo<SysDict> findByPage(PageParameter<SysDict> pageParameter) {
        return sysDictService.findByPage(pageParameter);
    }
}
