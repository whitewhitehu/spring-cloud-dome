package com.spdata.crm.configuration.entrypoint;

import com.alibaba.fastjson.JSON;
import com.spdata.common.base.BaseResul;
import com.spdata.common.base.Basemessage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author yangqifang
 * @描述:
 * @data 2018/12/1113:20
 **/
@Slf4j
@Component
public class SpdataAuthenticationEntryPoint implements AuthenticationEntryPoint {
    @Override
    public void commence(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, AuthenticationException e) throws IOException, ServletException {
        PrintWriter writer = null;
        httpServletResponse.setStatus(HttpServletResponse.SC_OK);
        httpServletResponse.setContentType("application/json");
        httpServletResponse.setCharacterEncoding("UTF-8");
        try {
            BaseResul baseResul = new BaseResul();
            baseResul.setCode(Basemessage.TokenTimeOutCode);
            baseResul.setMessage("无效token:" + e.getLocalizedMessage());
            baseResul.setData(null);
            writer = httpServletResponse.getWriter();
            writer.write(JSON.toJSONString(baseResul));
        } catch (Exception e1) {
            log.error(e1.getMessage());
        } finally {
            writer.close();
        }
    }
}
