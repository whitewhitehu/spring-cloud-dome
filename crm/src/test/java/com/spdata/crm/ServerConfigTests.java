package com.spdata.crm;

import com.spdata.common.base.PageParameter;
import com.spdata.common.config.Properties;
import com.spdata.crm.serverconfig.service.PropertiesService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * @author yangqifang
 * @描述:
 * @data 2019/3/721:29
 **/
@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
public class ServerConfigTests {

    @Autowired
    private PropertiesService propertiesService;

    @Test
    public void save() {
        Properties properties = new Properties();
        properties.setKey("server.port");
        properties.setValue("8084");
        properties.setApplication("test-server4");
        properties.setProfile("test");
        properties.setLabel("a");
        propertiesService.save(properties);
    }

    @Test
    public void update() {
        Properties properties = new Properties();

    }

    @Test
    public void delect() {
        Properties properties = new Properties();

    }

    @Test
    public void findByPage() {
        Properties properties = new Properties();
        PageParameter pageParameter = new PageParameter();
        pageParameter.setParament(properties);
        pageParameter.setPagenum(1);
        pageParameter.setPagesize(2);
        List<Properties> list = propertiesService.findByPage(pageParameter).getList();
        log.info(list.toString());
    }
}
