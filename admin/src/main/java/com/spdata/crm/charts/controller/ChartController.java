package com.spdata.crm.charts.controller;

import com.spdata.common.base.BaseResul;
import com.spdata.common.base.Basemessage;
import com.spdata.crm.charts.service.ChartService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * @author yangqifang
 * @描述:
 * @data 2019/2/2720:11
 **/
@RestController
@RequestMapping(value = "/chart")
public class ChartController {
    Logger logger = LoggerFactory.getLogger(ChartController.class);
    @Autowired
    private ChartService chartService;

    @PostMapping(value = "/create")
    public BaseResul create(@RequestBody Map<String, String> map) {
        BaseResul resul = new BaseResul();
        try {
            String vue_content = chartService.createFile(map);
            resul.setData(vue_content);
        } catch (Exception e) {
            logger.warn(e.getMessage());
            resul.setMessage(Basemessage.error_message);
            resul.setCode(Basemessage.error);
        }
        return resul;
    }
}
