package com.spdata.crm;

import com.spdata.crm.charts.service.ChartService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * @author yangqifang
 * @描述:
 * @data 2019/2/2716:11
 **/
@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
public class ChartServiceTest {
    @Autowired
    private ChartService chartService;

    @Test
    public void test() throws IOException {
        Map<String, String> map = new HashMap<>();
        map.put("type", "line");
        map.put("chartSettings", "这个是chartSettings");
        map.put("chartData", "这个是chartData");
        try {
            chartService.createFile(map);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
