package com.yangqifang.crm.api.sysdict.service;

import com.github.pagehelper.PageInfo;
import com.yangqifang.common.base.PageParameter;
import com.yangqifang.crm.api.sysdict.entity.SysDict;

/**
 * @author: yangqifang
 * @mall:yangqifang@baoku.com
 * @description: 2019/12/29 1:40
 */
public interface ICrmSysDictService {
    SysDict insert(SysDict sysDict);
    boolean update(SysDict sysDict);
    boolean delect(SysDict sysDict);
    boolean save(SysDict sysDict);
    PageInfo<SysDict> findByPage(PageParameter<SysDict> pageParameter);
}
