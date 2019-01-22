package com.spdata.crm.sysdict.service;

import com.spdata.common.base.BaseService;
import com.spdata.common.sysdict.SysDict;
import com.spdata.crm.sysdict.dao.SysDictDao;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author yangqifang
 * @描述:
 * @data 2019/1/2214:58
 **/
@Log
@Service
public class SysDictService extends BaseService<SysDictDao, SysDict> {
    @Autowired
    private SysDictDao sysDictDao;

    /**
     * 插入字典
     *
     * @param sysDict
     * @return
     */
    @Override
    public SysDict insert(SysDict sysDict) {
        return super.insert(sysDict);
    }

    /**
     * 修改字典
     *
     * @param sysDict
     * @return
     */
    public boolean update(SysDict sysDict) {
        return sysDictDao.update(sysDict);
    }
}
