package com.spdata.crm.charts.service;

import freemarker.template.Configuration;
import freemarker.template.Template;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;

import java.util.Map;

/**
 * @author yangqifang
 * @描述:
 * @data 2019/2/2715:55
 **/
@Service
public class ChartService {
    @Autowired
    private Configuration configuration;
    Logger logger = LoggerFactory.getLogger(ChartService.class);
    private final String type = "type";
    private final String chartSettings = "chartSettings";
    private final String chartData = "chartData";

    public String createFile(Map<String, String> map) throws Exception {
        String text = null;
        if (validation(map)) {
            Template template = configuration.getTemplate(map.get(this.type) + ".ftl");
            text = FreeMarkerTemplateUtils.processTemplateIntoString(template, map);
            logger.info(Thread.currentThread().getName() + "生成图表");
        }

        return text;
    }

    private boolean validation(Map<String, String> map) throws Exception {
        if (map.get(type) == null) {
            throw new Exception("找不到这个类型");
        }
        if (map.get(chartData) == null) {
            throw new Exception("找不到chartData");
        }
        if (map.get(chartSettings) == null) {
            throw new Exception("找不到chartSettings");
        }
        return true;
    }
}
