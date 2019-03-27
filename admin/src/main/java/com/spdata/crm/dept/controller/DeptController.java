package com.spdata.crm.dept.controller;

import com.spdata.common.account.Account;
import com.spdata.common.base.BaseResul;
import com.spdata.common.base.Basemessage;
import com.spdata.common.dept.Dept;
import com.spdata.crm.account.service.AccountService;
import com.spdata.crm.dept.entity.DeptTree;
import com.spdata.crm.dept.service.DeptService;
import com.spdata.crm.tool.SpringOauth2SecurityTool;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
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
    @Autowired
    private DeptService deptService;
    @Autowired
    private AccountService accountService;

    @GetMapping(value = "/deptlist")
    public BaseResul DeptList() {
        BaseResul resul = new BaseResul();
        try {
            Account account = accountService.findAccount(SpringOauth2SecurityTool.getSecurityUserName());
            List<DeptTree> deptTrees = deptService.getDeptTree(account.getDeptId());
            resul.setData(deptTrees);
        } catch (Exception e) {
            e.printStackTrace();
            resul.setCode(Basemessage.error);
            resul.setMessage(Basemessage.error_system_message);
        }
        return resul;
    }

    @PostMapping(value = "/save")
    public BaseResul save(@RequestBody Dept dept) {
        BaseResul resul = new BaseResul();
        try {
            boolean save = deptService.save(dept);
            resul.setData(save);
        } catch (Exception e) {
            e.printStackTrace();
            resul.setCode(Basemessage.error);
            resul.setMessage(Basemessage.error_system_message);
        }
        return resul;
    }

    @PostMapping(value = "/update")
    public BaseResul update(@RequestBody Dept dept) {
        BaseResul resul = new BaseResul();
        try {
            boolean update = deptService.update(dept);
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
            boolean exist = deptService.exist(dept);
            resul.setData(exist);
        } catch (Exception e) {
            e.printStackTrace();
            resul.setCode(Basemessage.error);
            resul.setMessage(Basemessage.error_system_message);
        }
        return resul;
    }
}
