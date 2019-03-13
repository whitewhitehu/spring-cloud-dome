package com.spdata.crm.serverconfig.controller;

import com.spdata.common.base.BaseResul;
import com.spdata.common.base.Basemessage;
import com.spdata.common.base.PageParameter;
import com.spdata.common.config.Properties;
import com.spdata.crm.serverconfig.service.PropertiesService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.netflix.eureka.EurekaDiscoveryClient;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author yangqifang
 * @描述:
 * @data 2019/3/720:56
 **/
@RestController
@PreAuthorize("hasAuthority('ROOT')")
@RequestMapping(value = "/server/config")
public class PropertiesController {
    private Logger logger = LoggerFactory.getLogger(PropertiesController.class);
    @Autowired
    private PropertiesService propertiesService;

    /**
     * 查询服务配置
     *
     * @param pageParameter
     * @return
     */
    @PostMapping(value = "/list")
    public BaseResul list(@RequestBody PageParameter<Properties> pageParameter) {
        BaseResul baseResul = new BaseResul();
        try {
            baseResul.setData(propertiesService.findByPage(pageParameter));
        } catch (Exception e) {
            e.printStackTrace();
            logger.error(e.getLocalizedMessage());
            baseResul.setMessage(Basemessage.error_system_message);
            baseResul.setCode(Basemessage.error);
        }
        return baseResul;
    }

    /**
     * 添加服务配置
     *
     * @param properties
     * @return
     */
    @PostMapping(value = "/save")
    public BaseResul save(@RequestBody Properties properties) {
        BaseResul baseResul = new BaseResul();
        try {
            baseResul.setData(propertiesService.save(properties));
        } catch (Exception e) {
            e.printStackTrace();
            logger.error(e.getLocalizedMessage());
            baseResul.setMessage(Basemessage.error_system_message);
            baseResul.setCode(Basemessage.error);
        }
        return baseResul;
    }

    /**
     * 修改服务配置
     *
     * @param properties
     * @return
     */
    @PostMapping(value = "/update")
    public BaseResul update(@RequestBody Properties properties) {
        BaseResul baseResul = new BaseResul();
        try {
            baseResul.setData(propertiesService.update(properties));
        } catch (Exception e) {
            e.printStackTrace();
            logger.error(e.getLocalizedMessage());
            baseResul.setMessage(Basemessage.error_system_message);
            baseResul.setCode(Basemessage.error);
        }
        return baseResul;
    }

    /**
     * 删除服务配置
     *
     * @param properties
     * @return
     */
    @PostMapping(value = "/delect")
    public BaseResul delect(@RequestBody Properties properties) {
        BaseResul baseResul = new BaseResul();
        try {
            baseResul.setData(propertiesService.delect(properties));
        } catch (Exception e) {
            e.printStackTrace();
            logger.error(e.getLocalizedMessage());
            baseResul.setMessage(Basemessage.error_system_message);
            baseResul.setCode(Basemessage.error);
        }
        return baseResul;
    }
}
