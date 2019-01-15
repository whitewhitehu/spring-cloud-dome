package com.spdata.crm.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.annotation.*;
import org.springframework.context.annotation.Configuration;
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
    @Pointcut(value = "execution(* com.spdata.crm.role.service.RoleService.findByPage(..))")
    public void roleSave() {
    }
    @Before("roleSave()")
    public void run() {
       System.err.println("aaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
    }
}
