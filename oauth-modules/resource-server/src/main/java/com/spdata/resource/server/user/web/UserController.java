package com.spdata.resource.server.user.web;

import com.spdata.common.base.BaseResul;
import com.spdata.common.base.Basemessage;
import com.spdata.resource.server.user.server.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

/**
 * @author yangqifang
 * @描述:
 * @data 2019/3/17-21:34
 **/
@RestController
@RequestMapping(value = "/user")
public class UserController {
    Logger logger = LoggerFactory.getLogger(UserController.class);
    @Autowired
    private UserService userService;

    @RequestMapping(value = "/info")
    public BaseResul info(Principal user) {
        BaseResul baseResul = new BaseResul();
        try {
            baseResul.setData(userService.findBuAccountInfo(user.getName()));
        } catch (Exception e) {
            e.printStackTrace();
            baseResul.setCode(Basemessage.error);
            baseResul.setMessage(Basemessage.error_system_message);
            logger.error(System.currentTimeMillis() + "出现异常:" + this.getClass().getName());
            logger.error(e.getLocalizedMessage());
        }
        return baseResul;
    }
}
