package com.spdata.crm.account.Controller;

import com.alibaba.fastjson.JSON;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.github.pagehelper.PageInfo;
import com.spdata.crm.account.Service.AccountService;
import com.spdata.crm.role.Service.RoleService;
import com.spdata.entity.Account.Account;
import com.spdata.entity.Base.BaseResul;
import com.spdata.entity.Base.Basemessage;
import com.spdata.entity.Base.PageParameter;
import com.spdata.entity.Role.Role;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;


@Slf4j
@RestController
@RequestMapping("/Account")
public class AccountController {
    @Autowired
    private AccountService accountService;
    @Autowired
    private RoleService roleService;

    /**
     * 查询账户基础信息接口
     *
     * @param id 账户ID
     * @return
     */
    @GetMapping(value = "/get/{id}")
    @PreAuthorize(value = "hasRole('ADMIN')")
    public BaseResul get(@PathVariable(value = "id") Integer id) {
        BaseResul resul = new BaseResul();
        try {
            Account account = new Account();
            account.setId(id);
            account = accountService.findById(account);
            account.setPassword("*************");//密码脱敏
            resul.setData(account);
        } catch (Exception e) {
            log.warn(e.getMessage());
            resul.setMessage(Basemessage.error_message);
            resul.setCode(Basemessage.error);
        }
        return resul;
    }

    /**
     * 添加账户接口
     *
     * @param account:账户信息 JSON格式
     * @return
     */
    @PostMapping(value = "/save")
    @PreAuthorize(value = "hasRole('ADMIN')")
    public BaseResul save(@RequestBody Account account) {
        BaseResul resul = new BaseResul();
        try {
            boolean falg = accountService.save(account);
            resul.setData(falg);
        } catch (Exception e) {
            log.warn(e.getMessage());
            resul.setCode(Basemessage.error);
            resul.setMessage(Basemessage.error_message);
        }
        return resul;
    }

    /**
     * 删除账户接口
     *
     * @param account
     * @return
     */
    @PostMapping(value = "/delect")
    @PreAuthorize(value = "hasRole('ADMIN')")
    public BaseResul delect(Account account) {
        BaseResul resul = new BaseResul();
        try {
            boolean falg = accountService.delect(account);
            resul.setData(falg);
        } catch (Exception e) {
            log.warn(e.getMessage());
            resul.setCode(Basemessage.error);
            resul.setMessage(Basemessage.error_message);
        }
        return resul;
    }

    /**
     * 分页查询账户接口
     *
     * @param accountPageParameter
     * @return
     */
    @PostMapping(value = "/page")
    @PreAuthorize(value = "hasRole('ADMIN')")
    public BaseResul Page(PageParameter<Account> accountPageParameter) {
        BaseResul resul = new BaseResul();
        try {
            PageInfo<Account> pageInfo = accountService.findByPage(accountPageParameter);
            resul.setData(pageInfo);
        } catch (Exception e) {
            log.warn(e.getMessage());
            resul.setCode(Basemessage.error);
            resul.setMessage(Basemessage.error_message);
        }
        return resul;
    }

    /**
     * 修改密码接口
     *
     * @param account
     * @return
     */
    @PostMapping(value = "/updatePassword")
    public BaseResul updatePassword(Account account) {
        BaseResul resul = new BaseResul();
        try {
            boolean falg = accountService.updatePassword(account);
            resul.setData(falg);
        } catch (Exception e) {
            log.warn(e.getMessage());
            resul.setCode(Basemessage.error);
            resul.setMessage(Basemessage.error_message);
        }
        return resul;
    }

    /**
     * 查询当前用户信息接口
     *
     * @param user
     * @return
     */
    @GetMapping(value = "/info")
    public BaseResul currentAccount(Principal user) {
        BaseResul resul = new BaseResul();
        try {
            Account account = accountService.findAccount(user.getName());
            String json = JSON.toJSONString(account);
            Map jsonmap = (Map) JSON.parse(json);
            OAuth2Authentication auth2Authentication = (OAuth2Authentication) user;
            List<? extends GrantedAuthority> collection = (List<? extends GrantedAuthority>) auth2Authentication.getUserAuthentication().getAuthorities();
            List<String> permissions = new ArrayList<>();
            collection.forEach(item -> {
                permissions.add(item.getAuthority());
            });
            jsonmap.put("permission", permissions);
            resul.setData(jsonmap);
        } catch (Exception e) {
            log.warn(e.getMessage());
            resul.setCode(Basemessage.error);
            resul.setMessage(Basemessage.error_message);
        }
        return resul;
    }

    /**
     * 查询当前用户拥有的角色信息接口
     *
     * @return
     */
    @GetMapping(value = "/roleinfo")
    public BaseResul roleinfo() {
        BaseResul resul = new BaseResul();
        try {
            List<Role> roles = roleService.findAccountRole();
            resul.setData(roles);
        } catch (Exception e) {
            log.warn(e.getMessage());
            resul.setCode(Basemessage.error);
            resul.setMessage(Basemessage.error_message);
        }
        return resul;
    }
}
