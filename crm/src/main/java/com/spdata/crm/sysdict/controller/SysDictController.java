package com.spdata.crm.sysdict.controller;

import com.github.pagehelper.PageInfo;
import com.spdata.common.base.BaseResul;
import com.spdata.common.base.Basemessage;
import com.spdata.common.base.PageParameter;
import com.spdata.common.sysdict.SysDict;
import com.spdata.crm.sysdict.service.SysDictService;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

/**
 * @描述:
 * @auther yangqifang
 * @data 2019/1/1916:13
 **/
@Log
@RestController
@RequestMapping(value = "/sysdict")
public class SysDictController {
    @Autowired
    private SysDictService sysDictService;

    /**
     * 保存字典
     *
     * @param sysDict
     * @return
     */
    @PostMapping(value = "/save")
    @PreAuthorize(value = "hasAuthority('ROOT')")
    public BaseResul save(@RequestBody SysDict sysDict) {
        BaseResul resul = new BaseResul();
        try {
            SysDict dict = sysDictService.insert(sysDict);
            resul.setData(dict);
        } catch (Exception e) {
            e.printStackTrace();
            log.warning(e.getMessage());
            resul.setCode(Basemessage.error);
            resul.setMessage(Basemessage.error_system_message);
        }
        return resul;
    }

    /**
     * 查询字典
     *
     * @param parameter
     * @return
     */
    @PostMapping(value = "/list")
    @PreAuthorize(value = "hasAuthority('ROOT')")
    public BaseResul list(@RequestBody PageParameter<SysDict> parameter) {
        BaseResul resul = new BaseResul();
        try {
            PageInfo<SysDict> dictPageInfo = sysDictService.findByPage(parameter);
            resul.setData(dictPageInfo);
        } catch (Exception e) {
            e.printStackTrace();
            log.warning(e.getMessage());
            resul.setCode(Basemessage.error);
            resul.setMessage(Basemessage.error_system_message);
        }
        return resul;
    }

    /**
     * 修改字典
     *
     * @param sysDict
     * @return
     */
    @PostMapping(value = "/update")
    @PreAuthorize(value = "hasAuthority('ROOT')")
    public BaseResul update(@RequestBody SysDict sysDict) {
        BaseResul resul = new BaseResul();
        try {
            boolean falg = sysDictService.update(sysDict);
            resul.setData(falg);
        } catch (Exception e) {
            e.printStackTrace();
            log.warning(e.getMessage());
            resul.setCode(Basemessage.error);
            resul.setMessage(Basemessage.error_system_message);
        }
        return resul;
    }
}
