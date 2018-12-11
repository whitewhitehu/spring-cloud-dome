package com.spdata.crm.configuration.entrypoint;

import com.alibaba.fastjson.JSON;
import com.spdata.entity.Base.BaseResul;
import com.spdata.entity.Base.Basemessage;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @描述:
 * @auther yangqifang
 * @data 2018/12/1113:20
 **/
@Component
public class SpdataAuthenticationEntryPoint implements AuthenticationEntryPoint {
    @Override
    public void commence(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, AuthenticationException e) throws IOException, ServletException {
        BaseResul baseResul = new BaseResul();
        baseResul.setCode(Basemessage.ParameterError);
        baseResul.setMessage("无效token:" + e.getLocalizedMessage());
        baseResul.setData(null);
        httpServletResponse.setStatus(HttpServletResponse.SC_FORBIDDEN);
        httpServletResponse.setContentType("application/json");
        httpServletResponse.setCharacterEncoding("UTF-8");
        PrintWriter writer = httpServletResponse.getWriter();
        writer.write(JSON.toJSONString(baseResul));
        writer.close();
    }
}
