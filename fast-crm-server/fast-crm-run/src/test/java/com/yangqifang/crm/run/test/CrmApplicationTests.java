package com.yangqifang.crm.run.test;

import com.yangqifang.crm.api.account.entity.AbstractAccount;
import com.yangqifang.crm.biz.account.service.AccountService;
import com.yangqifang.crm.run.CrmApplication;
import lombok.extern.log4j.Log4j2;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author: yangqifang
 * @mall:yangqifang@baoku.com
 * @description: 2019/12/29 2:11
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = CrmApplication.class)
@Log4j2
public class CrmApplicationTests {
    @Autowired
    private AccountService accountService;
    @Test
    public void test() {
        AbstractAccount abstractAccount = accountService.findAccount("root");
        log.info(abstractAccount);
    }
}
