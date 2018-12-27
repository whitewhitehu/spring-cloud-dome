package com.spdata.crm.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * @描述: 角色切面
 * @auther yangqifang
 * @data 2018/12/2017:18
 **/
@Slf4j
@Aspect
@Component
public class RoleAspect {
    @Pointcut(value = "execution(* com.spdata.crm.role.service.RoleService.*(..))")
    public void roleSave() {
    }

    @After("roleSave()")
    public void run() {
        log.info("After: run");
    }
}
