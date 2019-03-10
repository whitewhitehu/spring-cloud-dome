package com.spdata.crm.configuration.handler;

import com.alibaba.fastjson.JSON;
import com.spdata.common.base.BaseResul;
import com.spdata.common.base.Basemessage;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @描述:
 * @auther yangqifang
 * @data 2018/12/1113:17
 **/
@Component
public class SpdataAccessDeniedHandler implements AccessDeniedHandler {
    @Override
    public void handle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, AccessDeniedException e) throws IOException, ServletException {
        BaseResul baseResul = new BaseResul();
        baseResul.setMessage(e.getLocalizedMessage());
        baseResul.setCode(Basemessage.Refuse);
        baseResul.setData(null);
        httpServletResponse.setStatus(HttpServletResponse.SC_FORBIDDEN);
        httpServletResponse.setContentType("application/json");
        httpServletResponse.setCharacterEncoding("UTF-8");
        PrintWriter writer = httpServletResponse.getWriter();
        writer.write(JSON.toJSONString(baseResul));
        writer.close();
    }
}
