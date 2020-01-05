package com.yangqifang.crm.dept.controller;

import org.apache.dubbo.config.annotation.Reference;
import com.yangqifang.common.base.BaseResul;
import com.yangqifang.common.base.Basemessage;
import com.yangqifang.crm.api.account.entity.AbstractAccount;
import com.yangqifang.crm.api.account.service.ICrmAccountService;
import com.yangqifang.crm.api.dept.dto.DeptTree;
import com.yangqifang.crm.api.dept.entity.Dept;
import com.yangqifang.crm.api.dept.service.ICrmDeptService;
import com.yangqifang.crm.tool.SpringOauth2SecurityTool;
import lombok.extern.java.Log;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author yangqifang
 * @描述:
 * @data 2019/1/2217:59
 **/
@Log
@RestController
@RequestMapping(value = "/dept")
public class DeptController {
    @Reference
    private ICrmDeptService crmDeptService;
    @Reference
    private ICrmAccountService crmAccountService;

    @GetMapping(value = "/deptlist")
    @PreAuthorize("hasRole('ADMIN')")
    public BaseResul DeptList() {
        BaseResul resul = new BaseResul();
        try {
            AbstractAccount account = crmAccountService.findAccount(SpringOauth2SecurityTool.getSecurityUserName());
            List<DeptTree> deptTrees = crmDeptService.getDeptTree(account.getDeptId());
            resul.setData(deptTrees);
        } catch (Exception e) {
            e.printStackTrace();
            resul.setCode(Basemessage.error);
            resul.setMessage(Basemessage.error_system_message);
        }
        return resul;
    }

    @PostMapping(value = "/save")
    @PreAuthorize("hasRole('ADMIN')")
    public BaseResul save(@RequestBody Dept dept) {
        BaseResul resul = new BaseResul();
        try {
            boolean save = crmDeptService.save(dept);
            resul.setData(save);
        } catch (Exception e) {
            e.printStackTrace();
            resul.setCode(Basemessage.error);
            resul.setMessage(Basemessage.error_system_message);
        }
        return resul;
    }

    @PostMapping(value = "/update")
    @PreAuthorize("hasRole('ADMIN')")
    public BaseResul update(@RequestBody Dept dept) {
        BaseResul resul = new BaseResul();
        try {
            boolean update = crmDeptService.update(dept);
            resul.setData(update);
        } catch (Exception e) {
            e.printStackTrace();
            resul.setCode(Basemessage.error);
            resul.setMessage(Basemessage.error_system_message);
        }
        return resul;
    }

    @PostMapping(value = "/exist")
    public BaseResul exist(@RequestBody Dept dept) {
        BaseResul resul = new BaseResul();
        try {
            boolean exist = crmDeptService.exist(dept);
            resul.setData(exist);
        } catch (Exception e) {
            e.printStackTrace();
            resul.setCode(Basemessage.error);
            resul.setMessage(Basemessage.error_system_message);
        }
        return resul;
    }
}
