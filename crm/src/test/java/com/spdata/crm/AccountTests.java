package com.spdata.crm;

import com.github.pagehelper.PageInfo;
import com.spdata.common.account.Account;
import com.spdata.common.base.PageParameter;
import com.spdata.crm.account.entity.AccountVO;
import com.spdata.crm.account.service.AccountService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author yangqifang
 * @描述:
 * @data 2019/1/2418:44
 **/
@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
public class AccountTests {
    @Autowired
    private AccountService accountService;
    @Test
    public void testPage() {
        PageParameter<AccountVO> accountPageParameter = new PageParameter<>();
        Account account = accountService.findAccount("root");
        accountPageParameter.setParament((AccountVO) account);
        PageInfo pageInfo = accountService.findByPage(accountPageParameter);
        log.error("a");
    }
}
