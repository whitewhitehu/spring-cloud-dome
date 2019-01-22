package com.spdata.crm;

import com.github.pagehelper.PageInfo;
import com.spdata.common.base.PageParameter;
import com.spdata.common.sysdict.SysDict;
import com.spdata.crm.sysdict.service.SysDictService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author yangqifang
 * @描述:
 * @data 2019/1/2215:06
 **/
@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
public class SysDictTests {
    @Autowired
    private SysDictService sysDictService;

    @Test
    public void findpage() {
        PageParameter<SysDict> pageParameter = new PageParameter<>();
        pageParameter.setPagenum(1);
        pageParameter.setPagesize(10);
        SysDict dict = new SysDict();
        dict.setIsDel(0);
        pageParameter.setParament(dict);
        PageInfo pageInfo = sysDictService.findByPage(pageParameter);
        log.warn(pageInfo.toString());
    }
}
