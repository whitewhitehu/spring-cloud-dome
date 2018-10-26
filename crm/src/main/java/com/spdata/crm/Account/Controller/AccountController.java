package com.spdata.crm.Account.Controller;

import com.github.pagehelper.PageInfo;
import com.spdata.crm.Account.Service.AccountService;
import com.spdata.crm.Role.Service.RoleService;
import com.spdata.crm.tool.SecurityTool;
import com.spdata.entity.Account.Account;
import com.spdata.entity.Base.BaseResul;
import com.spdata.entity.Base.Basemessage;
import com.spdata.entity.Base.PageParameter;
import com.spdata.entity.Role.Role;
import jdk.nashorn.internal.objects.annotations.Getter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.validation.ValidationAutoConfiguration;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.annotation.security.RolesAllowed;
import java.security.Principal;
import java.util.List;


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
            account.setPassword("***********");
            resul.setData(account);
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
