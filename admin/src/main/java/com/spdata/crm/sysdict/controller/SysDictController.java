package com.spdata.crm.sysdict.controller;

import com.github.pagehelper.PageInfo;
import com.spdata.common.base.BaseResul;
import com.spdata.common.base.Basemessage;
import com.spdata.common.base.PageParameter;
import com.spdata.common.sysdict.SysDict;
import com.spdata.crm.sysdict.service.SysDictService;
import io.swagger.annotations.*;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

/**
 * @author yangqifang
 * @描述: 系统字典接口类
 * @data 2019/1/1916:13
 **/
@Api("系统字典接口")
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
    @ApiOperation(value = "添加字典")
    @PostMapping(value = "/save")
    @PreAuthorize(value = "hasAuthority('ROOT')")
    public BaseResul save(@RequestBody SysDict sysDict) {
        BaseResul resul = new BaseResul();
        try {
            boolean dict = sysDictService.save(sysDict);
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

    /**
     * 删除字典
     *
     * @param sysDict
     * @return
     */
    @PostMapping(value = "/delect")
    @PreAuthorize(value = "hasAuthority('ROOT')")
    public BaseResul delect(@RequestBody SysDict sysDict) {
        BaseResul resul = new BaseResul();
        try {
            boolean falg = sysDictService.delect(sysDict);
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
